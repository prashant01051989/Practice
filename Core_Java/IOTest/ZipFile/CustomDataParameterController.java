package com.ironmountain.recordcenter.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.types.CDPTemplateTypeEnum;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.common.uriframework.Link;
import com.ironmountain.domain.dto.common.SearchAndFilterDto;
import com.ironmountain.domain.dto.org.CustomerSummaryWrapper;
import com.ironmountain.domain.orm.rc2db.cdp.CustomDataParameterTemplate;
import com.ironmountain.domain.orm.rc2db.cdp.CustomDataParameterTemplateFieldMapListWrapper;
import com.ironmountain.dto.cdp.CustomDataParameterCustomerRequestDto;
import com.ironmountain.dto.cdp.CustomDataParameterListWrapperDto;
import com.ironmountain.dto.cdp.CustomDataParameterTemplateFieldMapListWrapperDto;
import com.ironmountain.dto.cdp.CustomDataParameterTemplateHighLevelSummaryDto;
import com.ironmountain.dto.cdp.CustomDataParameterTemplateSummaryDto;
import com.ironmountain.dto.orgs.customer.CustomerSummaryWrapperDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.CustomDataParameterService;

@Controller
public class CustomDataParameterController {

    private static final String DEFAULT_CDP = "default";
    @Autowired
    private CustomDataParameterService customDataParameterService;
    @Autowired
    private IronMountainMapper objectMapper;

    @RequestMapping(value = RecordCenterUriFormats.COMANPY_CDP, method = RequestMethod.GET)
    public @ResponseBody
    CustomDataParameterListWrapperDto getCDPsForCompany(@PathVariable long companyId, String type,
            SearchAndFilterDto safDto) {

        CustomDataParameterListWrapperDto customDataParameterListWrapperDto =
                objectMapper.map(
                        customDataParameterService.getCustomDataParameterListForCompany(SecurityContextHolder
                                .getContext().getAuthentication().getName(), companyId,
                                CDPTemplateTypeEnum.fromString(type), safDto), CustomDataParameterListWrapperDto.class);

        for (CustomDataParameterTemplateSummaryDto summaryDto : customDataParameterListWrapperDto.getEntityList()) {
            if (summaryDto.getGoatId().equals("1")) {
                summaryDto.setGoatId(DEFAULT_CDP);
                break;
            }
        }

        return customDataParameterListWrapperDto;
    }

    @RequestMapping(value = RecordCenterUriFormats.COMANPY_CDP + "/customers", method = RequestMethod.GET)
    public @ResponseBody
    CustomerSummaryWrapperDto getCustomersWithoutCDP(@PathVariable long companyId, String type,
            SearchAndFilterDto safDto) {

        CustomerSummaryWrapper customerSummaryWrapper =
                customDataParameterService.getCustomersWithoutCDP(SecurityContextHolder.getContext()
                        .getAuthentication().getName(), companyId, CDPTemplateTypeEnum.fromString(type), safDto);

        return objectMapper.map(customerSummaryWrapper, CustomerSummaryWrapperDto.class);
    }

    @RequestMapping(value = RecordCenterUriFormats.COMANPY_CDP + "/{cdpId}", method = RequestMethod.GET)
    public @ResponseBody
    CustomDataParameterTemplateHighLevelSummaryDto getCDP(@PathVariable long companyId, @PathVariable String cdpId,
            @RequestParam(defaultValue = "BOX") String type) {
        long realCdpId = convertCdpId(cdpId, type);
        return objectMapper.map(
                customDataParameterService.getCustomDataParameterSummary(SecurityContextHolder.getContext()
                        .getAuthentication().getName(), companyId, realCdpId),
                CustomDataParameterTemplateHighLevelSummaryDto.class);
    }

    @RequestMapping(value = RecordCenterUriFormats.COMANPY_CDP, method = RequestMethod.POST)
    public @ResponseBody
    CustomDataParameterListWrapperDto getCDPTemplatesForCustomers(@PathVariable long companyId,
            @RequestParam(defaultValue = "BOX") String type, SearchAndFilterDto safDto,
            @RequestBody CustomDataParameterCustomerRequestDto customers) {
        final Set<String> customerIdSet = new HashSet<String>();
        if (customers.getCustomerList() != null) {
            for (Link link : customers.getCustomerList()) {
                customerIdSet.add(link.getGoatId());
            }
        }
        return objectMapper.map(customDataParameterService.getCustomDataParameterListForCustomers(SecurityContextHolder
                .getContext().getAuthentication().getName(), companyId, CDPTemplateTypeEnum.fromString(type),
                customerIdSet, safDto), CustomDataParameterListWrapperDto.class);
    }

    @RequestMapping(value = RecordCenterUriFormats.COMANPY_CDP + "/{cdpId}/parameters", method = RequestMethod.GET)
    public @ResponseBody
    CustomDataParameterTemplateFieldMapListWrapperDto getCDPParameters(@PathVariable long companyId,
            @PathVariable String cdpId, @RequestParam(defaultValue = "BOX") String type) {
        long realCdpId = convertCdpId(cdpId, type);
        CustomDataParameterTemplate cdpTemplate =
                customDataParameterService.getCustomDataParameter(SecurityContextHolder.getContext()
                        .getAuthentication().getName(), companyId, realCdpId);
        CustomDataParameterTemplateFieldMapListWrapper fieldsWrapper =
                new CustomDataParameterTemplateFieldMapListWrapper();
        fieldsWrapper.setCdpId(realCdpId);
        fieldsWrapper.setCompanyId(companyId);
        if (cdpTemplate != null) {
            int count = cdpTemplate.getFieldMaps().size();
            fieldsWrapper.setEntityList(cdpTemplate.getFieldMaps());
            fieldsWrapper.setCount(count);
            fieldsWrapper.setTotal(count);
        }
        return objectMapper.map(fieldsWrapper, CustomDataParameterTemplateFieldMapListWrapperDto.class);
    }

    private long convertCdpId(String cdpId, String type) {
        long realCdpId = -1L;
        if (DEFAULT_CDP.equalsIgnoreCase(cdpId)) {
            List<CustomDataParameterTemplate> templates =
                    customDataParameterService.getDefaultCpdTemplates(CDPTemplateTypeEnum.fromString(type));
            if (templates != null && !templates.isEmpty()) {
                realCdpId = templates.get(0).getId();
            }
        } else {
            try {
                realCdpId = Long.valueOf(cdpId);
            } catch (NumberFormatException e) {
                // ignore
            }
        }
        if (realCdpId == -1L) {
            throw new EntityNotFoundException("Custom Data Parameter Template [" + cdpId + "] is not found");
        }
        return realCdpId;
    }
}
