package com.ironmountain.recordcenter.controller;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.common.SafMapper;
import com.ironmountain.domain.dto.common.SafMapperFactory;
import com.ironmountain.domain.dto.common.SafMapperFieldConverterImpl;
import com.ironmountain.domain.dto.common.SearchAndFilterDto;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.company.CompanyProfile;
import com.ironmountain.domain.orm.rc2db.company.CompanyProfileHistoryWrapper;
import com.ironmountain.dto.orgs.company.CompanyProfileDto;
import com.ironmountain.dto.orgs.company.CompanyProfileHistoryWrapperDto;
import com.ironmountain.dto.orgs.company.CompanyProfileResultDto;
import com.ironmountain.recordcenter.service.RC2OrganizationSummaryService;

@Controller
public class OrganizationController {
	private final static Logger LOG = LoggerFactory.getLogger(OrganizationController.class);

	@Autowired
	private RC2OrganizationSummaryService rC2OrganizationSummaryService;

	@Autowired
	private IronMountainMapper objectMapper;
	
	
	static {
		// CustomSupplyHistWrapperDto -> CustomSupplyHistWrapper
		SafMapper safMapper = new SafMapper();
		safMapper.addFieldConverter("modifiedDate", new SafMapperFieldConverterImpl("modifiedDate"));
		SafMapperFactory.instance().addMapper(CompanyProfileHistoryWrapperDto.class, CompanyProfileHistoryWrapper.class, safMapper);
	}

	@RequestMapping(value = "/api/app/users/{userId}/companies/{companyId}/profile", method = RequestMethod.GET)
	public @ResponseBody
	CompanyProfileDto getCompanyProfile(@PathVariable String userId, @PathVariable String companyId) {
		CompanyProfile companyProfile = rC2OrganizationSummaryService.getCompanyProfile(userId, companyId);
		return objectMapper.map(companyProfile, CompanyProfileDto.class);
	}

	@RequestMapping(value = "/api/app/users/{userId}/companies/{companyId}/profile", method = RequestMethod.PUT)
	public @ResponseBody
	CompanyProfileResultDto setCompanyProfile(@PathVariable String userId, @PathVariable String companyId,
			@RequestBody CompanyProfileDto profileDto) {
		CompanyProfile companyProfile = objectMapper.map(profileDto, CompanyProfile.class);
		ServiceResult<CompanyProfile> result = null;

		try {
			result = rC2OrganizationSummaryService.setCompanyProfile(userId, companyProfile);
		} catch (EntityNotFoundException e) {
			LOG.error("Failed to save company profile: ", e);
			throw e;
		}

		return objectMapper.map(result, CompanyProfileResultDto.class);
	}

	@RequestMapping(value = "/api/app/users/{userId}/companies/{companyId}/profile/changeHistories", method = RequestMethod.GET)
	public @ResponseBody
	CompanyProfileHistoryWrapperDto getCompanyProfileHistories(@PathVariable String companyId, SearchAndFilterDto safDto) {
		SafMapperFactory.instance().map(CompanyProfileHistoryWrapperDto.class, CompanyProfileHistoryWrapper.class, safDto);
		CompanyProfileHistoryWrapper profileHistoryWrapper = rC2OrganizationSummaryService.getCompanyProfileHistory(companyId, safDto);
		return objectMapper.map(profileHistoryWrapper, CompanyProfileHistoryWrapperDto.class);
	}
	
}
