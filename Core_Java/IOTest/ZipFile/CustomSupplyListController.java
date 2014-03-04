package com.ironmountain.recordcenter.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.constants.AppConstants;
import com.ironmountain.common.exception.SecurityException;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.common.uriframework.Link;
import com.ironmountain.domain.dto.common.SafMapper;
import com.ironmountain.domain.dto.common.SafMapperFactory;
import com.ironmountain.domain.dto.common.SafMapperFieldConverterImpl;
import com.ironmountain.domain.dto.common.SearchAndFilterDto;
import com.ironmountain.domain.dto.org.CustomerSummaryWrapper;
import com.ironmountain.domain.dto.supplies.CustomSuppCustomerWrapper;
import com.ironmountain.domain.dto.supplies.CustomSuppSupplyWrapper;
import com.ironmountain.domain.dto.supplies.CustomSuppliesWrapper;
import com.ironmountain.domain.orm.rc2db.supplies.custom.CustomSupplyHistWrapper;
import com.ironmountain.domain.orm.rc2db.supplies.custom.CustomSupplyList;
import com.ironmountain.dto.asset.supplies.SuppliesWrapperDto;
import com.ironmountain.dto.asset.supplies.SupplyDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSuppliesDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyAssociatedSuppliesWrapperDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyHistWrapperDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyLinksDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyListAssociatedCustomersDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyListCustomersDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplySuppliesWrapperDto;
import com.ironmountain.dto.asset.supplies.custom.CustomSupplyWrapperDto;
import com.ironmountain.dto.asset.supplies.custom.CustomersForCustomSupplyListDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.controller.util.SupplyListControllerUtil;
import com.ironmountain.recordcenter.rest.CoreServicesInvoker;
import com.ironmountain.recordcenter.service.CustomSupplyListService;
import com.ironmountain.recordcenter.service.CustomSupplyService;

@Controller
public class CustomSupplyListController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSupplyListController.class);

	@Autowired
	private CustomSupplyListService customSupplyListService;

	@Autowired
	private CustomSupplyService customSupplyService;

	@Autowired
	private IronMountainMapper objectMapper;

	@Autowired
	private CoreServicesInvoker invoker;

	static {
		// CustomSupplyHistWrapperDto -> CustomSupplyHistWrapper
		SafMapper safMapper = new SafMapper();
		safMapper.addFieldConverter("modifiedBy", new SafMapperFieldConverterImpl("userId"));
		safMapper.addFieldConverter("dateTime", new SafMapperFieldConverterImpl("transactionDateTime"));
		safMapper.addFieldConverter("actionDetails", new SafMapperFieldConverterImpl("actionDesc"));
		SafMapperFactory.instance().addMapper(CustomSupplyHistWrapperDto.class, CustomSupplyHistWrapper.class, safMapper);
	}

	// This method is called during the creation of the new custom supply list
	@RequestMapping(value = RecordCenterUriFormats.RECORDS_MANAGEMENT_PATH + "/companies/{companyId}/supplies", method = RequestMethod.POST)
	public @ResponseBody
	SuppliesWrapperDto getAllSuppliesForCustomerIds(
			@RequestBody SuppliesWrapperDto suppliesWrapperDto,
			@PathVariable String companyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		return customSupplyListService.getAllSuppliesForCustomerIds(suppliesWrapperDto, companyId,
				SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFields));

	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}", method = RequestMethod.GET)
	public @ResponseBody
	CustomSupplyLinksDto getCustomSupplyList(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("companyId") final String companyId, @PathVariable("customSupplyId") final String customSupplyId) {

		customSupplyService.hasCustomSupplyListPermission();
		Long custSupplyId = Long.valueOf(-1); // For default customers
		if (!customSupplyId.equalsIgnoreCase(SupplyListControllerUtil.DEFAULT)) {
			try {
				custSupplyId = Long.valueOf(customSupplyId);
			} catch (NumberFormatException nfe) {
				LOGGER.error("Exception when getting CustomSupplyList associated customers: ", nfe);
				throw new RuntimeException(nfe);
			}
		}
		CustomSuppCustomerWrapper customSuppCustomerWrapper = new CustomSuppCustomerWrapper();
		customSuppCustomerWrapper.setCompanyId(Integer.valueOf(companyId));
		customSuppCustomerWrapper.setCustomSupplyId(custSupplyId);
		CustomSupplyLinksDto customSupplyLinksDto = objectMapper.map(customSuppCustomerWrapper, CustomSupplyLinksDto.class);
		if (customSupplyLinksDto.getGoatId().equalsIgnoreCase("-1")) {
			customSupplyLinksDto.setGoatId(SupplyListControllerUtil.DEFAULT);
			customSupplyLinksDto.setUri(customSupplyLinksDto.getUri().replace("-1", SupplyListControllerUtil.DEFAULT));
			Link link = customSupplyLinksDto.getCustomers();
			link.setGoatId(SupplyListControllerUtil.DEFAULT);
			link.setUri(link.getUri().replace("-1", SupplyListControllerUtil.DEFAULT));
		}
		return customSupplyLinksDto;

	}

	// Posting a new custom supply list
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies", method = RequestMethod.POST)
	public @ResponseBody
	CustomSupplyWrapperDto saveCustomSupplyList(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("companyId") final String companyId, @RequestBody CustomSupplyWrapperDto customSupplyWrapperDto) {

		CustomSupplyList customSupplyList = objectMapper.map(customSupplyWrapperDto, CustomSupplyList.class);
		customSupplyList.setCreatedBy(request.getUserPrincipal().getName());
		customSupplyList.setCompanyId(companyId);
		Long id = customSupplyService.saveCustomSupplyList(customSupplyList);
		if (id != null) {
			customSupplyWrapperDto.setGoatId(id.toString());
		}
		return customSupplyWrapperDto;
	}

	// TODO reuse this method
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/delta", method = RequestMethod.PUT)
	public @ResponseBody
	CustomSupplyLinksDto editCustomSupplyListDelta(HttpServletRequest request, @PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId, @RequestBody CustomSupplyWrapperDto customSupplyWrapperDto) {
		customSupplyWrapperDto.setCompanyId(companyId);
		CustomSupplyList customSupplyList = objectMapper.map(customSupplyWrapperDto, CustomSupplyList.class);
		customSupplyService.editCustomSupplyListDelta(customSupplyList, Long.valueOf(customSupplyId));
		CustomSuppCustomerWrapper customSuppCustomerWrapper = new CustomSuppCustomerWrapper();
		customSuppCustomerWrapper.setCompanyId(Integer.valueOf(companyId));
		customSuppCustomerWrapper.setCustomSupplyId(Long.valueOf(customSupplyId));
		return objectMapper.map(customSuppCustomerWrapper, CustomSupplyLinksDto.class);

	}

	// Updating the complete supply List
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}", method = RequestMethod.PUT)
	public @ResponseBody
	void editCustomSupplyList(HttpServletRequest request, @PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId, @RequestBody CustomSupplyWrapperDto customSupplyWrapperDto) {

		CustomSupplyList customSupplyList = objectMapper.map(customSupplyWrapperDto, CustomSupplyList.class);
		customSupplyList.setCreatedBy(request.getUserPrincipal().getName());
		customSupplyList.setCompanyId(companyId);
		customSupplyService.editCustomSupplyList(customSupplyList, Long.valueOf(customSupplyId));

	}

	// Get List of customers during an edit
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/customers/edit", method = RequestMethod.GET)
	public @ResponseBody
	CustomSupplyListCustomersDto getEditCustomers(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {
		
		CustomSupplyListCustomersDto customSupplyEditCustomersDto = customSupplyService.getEditCustomerList(companyId, request
				.getUserPrincipal().getName(), Long.valueOf(customSupplyId), SupplyListControllerUtil.getQueryParamsMap(start, limit,
				sortField, sortBy, filterFields));
		CustomSuppCustomerWrapper customSuppCustomerWrapper = new CustomSuppCustomerWrapper();
		customSuppCustomerWrapper.setCompanyId(Integer.valueOf(companyId));
		customSuppCustomerWrapper.setCustomSupplyId(Long.valueOf(customSupplyId));
		CustomSupplyListCustomersDto customSupplyListCustomersDto = objectMapper.map(customSuppCustomerWrapper,
				CustomSupplyListCustomersDto.class);
		customSupplyListCustomersDto.setEntityList(customSupplyEditCustomersDto.getEntityList());
		customSupplyListCustomersDto.setTotal(customSupplyEditCustomersDto.getEntityList().size());
		customSupplyListCustomersDto.setCount(customSupplyEditCustomersDto.getEntityList().size());
		return customSupplyListCustomersDto;
		
	}

	// Get customers associated with the CSL during get
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/customers", method = RequestMethod.GET)
	public @ResponseBody
	CustomSupplyListAssociatedCustomersDto getCustomSupplyListAssociatedCustomers(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields)
			throws SecurityException {

		CustomSuppCustomerWrapper customSuppCustomerWrapper = customSupplyService.getCustomSupplyListAssociatedCustomers(companyId, request
				.getUserPrincipal().getName(), customSupplyId, SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy,
				filterFields));
		return objectMapper.map(customSuppCustomerWrapper, CustomSupplyListAssociatedCustomersDto.class);
	}

	// Get the supplies associated with the CSl during get
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/supplies", method = RequestMethod.GET)
	public @ResponseBody
	CustomSupplyAssociatedSuppliesWrapperDto getCustomSupplyListAssociatedSupplies(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		SuppliesWrapperDto coreServiceSupplies = invoker.getSupplyList(SecurityContextHolder.getContext().getAuthentication().getName(),
				companyId);
		List<String> supplyIdList = customSupplyService.getCustomSupplyAssociatedSupplies(customSupplyId, companyId);
		Iterator<SupplyDto> iter = coreServiceSupplies.getSupplyList().iterator();
		while (iter.hasNext()) {
			SupplyDto supplyDto = iter.next();
			if (!supplyIdList.contains(supplyDto.getGoatId())) {
				iter.remove();
			}
		}
		if (!coreServiceSupplies.getSupplyList().isEmpty()) {
			customSupplyListService.addAppSepecificdetails(coreServiceSupplies,
					SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFields));
			coreServiceSupplies.setCount((int) coreServiceSupplies.getTotal());
		}
		coreServiceSupplies.setCustomSupplyId(Long.valueOf(customSupplyId));
		return objectMapper.map(coreServiceSupplies, CustomSupplyAssociatedSuppliesWrapperDto.class);

	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/history", method = RequestMethod.GET)
	public @ResponseBody
	CustomSupplyHistWrapperDto getHistoryList(@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId, SearchAndFilterDto safDto) {
		
		SafMapperFactory.instance().map(CustomSupplyHistWrapperDto.class, CustomSupplyHistWrapper.class, safDto);

		CustomSupplyHistWrapper customSupplyHistWrapper = customSupplyService.getCSHistoryList(companyId, Long.valueOf(customSupplyId),
				safDto);
		customSupplyHistWrapper.setCustomSupplyId(Long.valueOf(customSupplyId));
		return objectMapper.map(customSupplyHistWrapper, CustomSupplyHistWrapperDto.class);

	}

	// This method is to get the list of supplies during editing the list. The
	// post body contains the delta modifications made to the CSL customers
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/supplies/delta", method = RequestMethod.POST)
	public @ResponseBody
	CustomSupplySuppliesWrapperDto getEditSuppliesDelta(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId,
			@RequestBody SuppliesWrapperDto suppliesWrapperDto,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		Long custSuppId = Long.parseLong(customSupplyId);
		CustomSupplySuppliesWrapperDto customSupplySuppliesWrapperDto = customSupplyService.getEditSupplyListDelta(suppliesWrapperDto,
				custSuppId, companyId, SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFields));
		CustomSuppSupplyWrapper suppliesWrapper = new CustomSuppSupplyWrapper();
		suppliesWrapper.setCustomSupplyId(custSuppId);

		CustomSupplySuppliesWrapperDto customSupplyEditSuppliesDto = objectMapper
				.map(suppliesWrapper, CustomSupplySuppliesWrapperDto.class);
		customSupplyEditSuppliesDto.setSupplyList(customSupplySuppliesWrapperDto.getSupplyList());
		customSupplyEditSuppliesDto.setCount(customSupplySuppliesWrapperDto.getSupplyList().size());
		customSupplyEditSuppliesDto.setTotal(customSupplySuppliesWrapperDto.getTotal());

		return customSupplyEditSuppliesDto;
	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}/supplies/edit", method = RequestMethod.POST)
	public @ResponseBody
	CustomSupplySuppliesWrapperDto getEditSupplies(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@PathVariable("customSupplyId") final String customSupplyId,
			@RequestBody SuppliesWrapperDto suppliesWrapperDto,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		Long custSuppId = Long.parseLong(customSupplyId);
		CustomSupplySuppliesWrapperDto customSupplySuppliesWrapperDto = customSupplyService.getEditSupplyList(suppliesWrapperDto,
				custSuppId, companyId, SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFields));
		CustomSuppSupplyWrapper suppliesWrapper = new CustomSuppSupplyWrapper();
		suppliesWrapper.setCustomSupplyId(custSuppId);

		CustomSupplySuppliesWrapperDto customSupplyEditSuppliesDto = objectMapper
				.map(suppliesWrapper, CustomSupplySuppliesWrapperDto.class);
		customSupplyEditSuppliesDto.setSupplyList(customSupplySuppliesWrapperDto.getSupplyList());
		customSupplyEditSuppliesDto.setCount(customSupplySuppliesWrapperDto.getSupplyList().size());
		customSupplyEditSuppliesDto.setTotal(customSupplySuppliesWrapperDto.getTotal());

		return customSupplyEditSuppliesDto;
	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/{customSupplyId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteCustomSupplyList(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("companyId") final String companyId, @PathVariable("customSupplyId") final String customSupplyId) {

		customSupplyService.removeCustomSupplyList(companyId, Long.valueOf(customSupplyId));
	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies", method = RequestMethod.GET)
	public @ResponseBody
	CustomSuppliesDto getCustomSupplies(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_START) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		/*
		 * If filter field contains char "," this method receives multiple items
		 * for filterFields ex : "a,b" filter string, but receives it as 2
		 * elements (a | b) in list, it could be becuase of marshalling not
		 * happening properly, it happens when user provide filter string for
		 * either customer id column or customer name column, for both it would
		 * not occur. So filter fields are taken from HttpServletRequest. This
		 * issue may not arise for some versions of spring REST api.
		 * 
		 * RC-24383
		 */
		String filterValues[] = request.getParameterValues(SupplyListControllerUtil.FILTERFIELDS);
		List<String> filterFieldsDup = null;
		if (filterValues != null)
			filterFieldsDup = Arrays.asList(filterValues);

		CustomSuppliesWrapper customSuppliesWrapper = customSupplyService.getCustomSupplies(companyId,
				request.getUserPrincipal().getName(),
				SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFieldsDup));
		CustomSuppliesDto customSuppliesDto = objectMapper.map(customSuppliesWrapper, CustomSuppliesDto.class);
		List<Link> customSupplyWrapperDtoList = customSuppliesDto.getCustomSupplies();
		for (Link link : customSupplyWrapperDtoList) {
			if (link.getGoatId().equalsIgnoreCase("-1")) {
				link.setGoatId(SupplyListControllerUtil.DEFAULT);
				link.setUri(link.getUri().replace("-1", SupplyListControllerUtil.DEFAULT));
				break;
			}
		}

		return customSuppliesDto;
	}

	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/companies/{companyId}/customSupplies/customers", method = RequestMethod.GET)
	public @ResponseBody
	CustomersForCustomSupplyListDto getCustomersForCustomSupplyList(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("companyId") final String companyId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortField,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields) {

		/*
		 * If filter field contains char "," this method receives multiple items
		 * for filterFields ex : "a,b" filter string, but receives it as 2
		 * elements (a | b) in list, it could be because of marshalling not
		 * happening properly, it happens when user provide filter string for
		 * either customer id column or customer name column, for both it would
		 * not occur. So filter fields are taken from HttpServletRequest. This
		 * issue may not arise for some versions of spring REST api.
		 * 
		 * RC-24464
		 */
		String filterValues[] = request.getParameterValues(SupplyListControllerUtil.FILTERFIELDS);
		List<String> filterFieldsDup = null;
		if (filterValues != null)
			filterFieldsDup = Arrays.asList(filterValues);
		CustomerSummaryWrapper customerSummaryWrapper = customSupplyService
				.getCustomersForCustomSupplyList(companyId, request.getUserPrincipal().getName(),
						SupplyListControllerUtil.getQueryParamsMap(start, limit, sortField, sortBy, filterFieldsDup));
		return objectMapper.map(customerSummaryWrapper, CustomersForCustomSupplyListDto.class);

	}

}
