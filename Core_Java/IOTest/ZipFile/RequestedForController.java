package com.ironmountain.recordcenter.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.constants.AppConstants;
import com.ironmountain.common.types.ServiceStatus;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.dto.requestedforusers.RequestedForUsersWrapper;
import com.ironmountain.domain.orm.rc2db.requestedforusers.RequestedForUser;
import com.ironmountain.dto.requestedforusers.RequestedForUserDto;
import com.ironmountain.dto.requestedforusers.RequestedForUserResultDto;
import com.ironmountain.dto.requestedforusers.RequestedForUsersWrapperDto;
import com.ironmountain.recordcenter.service.RecordCenterRequestedForService;

@Controller
public class RequestedForController {
	
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(RequestedForController.class);
	
	@Autowired
	private IronMountainMapper objectMapper;
	
	@Autowired
	private RecordCenterRequestedForService reqForUserService;

	private static final String RC_USER_URI = "/app/users/";
	private static final String REQ_FOR_USER_URI = "/app/requestedForUsers/companies/";

	@GET
	@RequestMapping(value="/api/app/requestedForUsers/companies/{companyId}", method=RequestMethod.GET)
    public @ResponseBody RequestedForUsersWrapperDto getRequestedForUsers(
    		@DefaultValue("") @PathVariable("companyId") final String companyId,
    		@DefaultValue("") @PathParam("userId") final String userId,
			@RequestParam(value = "startIndex", required = false, defaultValue = AppConstants.DEFAULT_SEARCH_REQ_USER_RESULTS_START) final Integer start,
			@RequestParam(value = "limit", required = false, defaultValue = AppConstants.DEFAULT_SEARCH_REQ_USER_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = "sortField", required = false) final String sortField,
			@RequestParam(value = "sortBy", required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = "filterFields", required = false) final List<String> filterFields
    		) {
		
		LOG.debug("Request param [companyId= " + companyId + "]");
		LOG.debug("Request param [userId= " + userId + "]");
		LOG.debug("Request param [start= " + start + "]");
		LOG.debug("Request param [limit= " + limit + "]");
		RequestedForUsersWrapperDto reqUserWrapperDto;
		try {
			Map<String,String> filterFieldsMap = new HashMap<String,String>();
			if(null!= filterFields && !filterFields.isEmpty()){				
				for(String fldValuePair : filterFields) {
					String[] pair=fldValuePair.split(":");
					String field=pair[0].replaceAll("[^a-zA-Z0-9]", "").trim();
					String value=pair[1].replaceAll("[^a-zA-Z0-9\\s.@]", "");
					filterFieldsMap.put(field, value);
				}
			}		
			List<RequestedForUser> reqUsersList = reqForUserService.getRequestedForUsers(companyId, userId, start, limit, sortField, sortBy,filterFieldsMap);
			RequestedForUsersWrapper reqUserWrapper = new RequestedForUsersWrapper();
			reqUserWrapper.setReqUsers(reqUsersList);
			reqUserWrapperDto = createReqUserWrapperDto(reqUserWrapper, companyId, userId, filterFieldsMap);
		} catch (Exception ex) {
			LOG.error("Exception getting Requested For Users.", ex);
			throw new RuntimeException(ex);
		}
		return reqUserWrapperDto;
    }
	
	
	@RequestMapping(value="/api/app/requestedForUsers/companies/{companyId}/{requstedForUserId}", method=RequestMethod.POST)
    public @ResponseBody RequestedForUserResultDto addRequestedForUser(@PathVariable("companyId") final String companyId, @PathVariable("requstedForUserId") final String requstedForUserId,
			@PathParam("userId") final String userId, @RequestBody RequestedForUserDto reqForUserDto) {
		RequestedForUserResultDto resultDto;
			
		LOG.debug("Request param [companyId= " + companyId + "]");
		LOG.debug("Request param [requstedForUserId= " + requstedForUserId + "]");
		LOG.debug("Request param [userId= " + userId + "]");
			
		RequestedForUser reqUser = objectMapper.map(reqForUserDto,RequestedForUser.class);
		reqUser.setCompanyId(Integer.parseInt(companyId));
		reqUser.setCreateDate(new Date());
		reqUser.setCreatedBy(userId);
			
		ServiceResult<RequestedForUser> serviceResult = null;
		if ("undefined".equals(requstedForUserId)) {
			serviceResult = reqForUserService.addRequestedForUser(reqUser);
		} else {
			reqUser.setRequestedForId(Long.valueOf(requstedForUserId));
			serviceResult = reqForUserService.updateRequestedForUser(reqUser);
		}

		resultDto = objectMapper.map(serviceResult,RequestedForUserResultDto.class);
		if (serviceResult.getObj().getRequestedForId() != null) {
			reqForUserDto.setUri(REQ_FOR_USER_URI + companyId + "/" + serviceResult.getObj().getRequestedForId());
			reqForUserDto.setEditable(true);
			reqForUserDto.setRequestedForId(serviceResult.getObj().getRequestedForId());
			resultDto.setObj(reqForUserDto);
		}

		if(serviceResult.getStatus().equals(ServiceStatus.FAILED)){
			resultDto.setResource(null);
		}
			
		return resultDto;
    }
		
	@RequestMapping(value="/api/app/requestedForUsers/companies/{companyId}/{userId}", method=RequestMethod.DELETE)
    public @ResponseBody RequestedForUserResultDto deleteRequestedForUser(@PathVariable("companyId") String companyId, @PathParam("userId") String userId) {
		//ModelAndView mav = new ModelAndView("jsonResponse");
		RequestedForUserResultDto resultDto;
		try {
			
			ServiceResult<RequestedForUser> serviceResult= reqForUserService.deleteRequestedForUser(Long.valueOf(userId));
			resultDto = objectMapper.map(serviceResult,RequestedForUserResultDto.class);
			
			if(serviceResult.getStatus().equals(ServiceStatus.FAILED)){
				resultDto.setResource(null);
			}
			
			//mav.addObject(resultDto);
			
		} catch (Exception ex) {
			LOG.error("Exception when deleting Req For User.", ex);
			throw new RuntimeException(ex);
		}
		return resultDto;
    }
	
	private RequestedForUsersWrapperDto createReqUserWrapperDto(final RequestedForUsersWrapper reqUserWrapper, final String companyId, final String userId, Map<String,String> filterFieldsMap) {
		RequestedForUsersWrapperDto reqUserWrapperDto = objectMapper.map(reqUserWrapper, RequestedForUsersWrapperDto.class);
		
		List<RequestedForUserDto> createRequestedForUserDto = new ArrayList<RequestedForUserDto>();
		for (RequestedForUserDto usersList : reqUserWrapperDto.getReqUsers()) {
			RequestedForUserDto requestedForUserDto = new RequestedForUserDto();
			requestedForUserDto.setFirstName(usersList.getFirstName());
			requestedForUserDto.setLastName(usersList.getLastName());
			requestedForUserDto.setEmailId(usersList.getEmailId());
			if (usersList.getFromTable() != null && usersList.getFromTable().equals(AppConstants.RCUSER)) {
				requestedForUserDto.setEditable(false);
				requestedForUserDto.setUri(RC_USER_URI  + usersList.getRequestedForId());
				requestedForUserDto.setRequestedForId(usersList.getRequestedForId());
			} else {
				requestedForUserDto.setEditable(true);
				requestedForUserDto.setUri(REQ_FOR_USER_URI + companyId + "/" + usersList.getRequestedForId());
				requestedForUserDto.setRequestedForId(usersList.getRequestedForId());
			}
			createRequestedForUserDto.add(requestedForUserDto);
		}

		reqUserWrapperDto.setUri(REQ_FOR_USER_URI + companyId + "?userId=" + userId);
		reqUserWrapperDto.setCount(createRequestedForUserDto.size());
		final long totalCount = reqForUserService.getRequestedForUsersTotalCount(companyId,filterFieldsMap);
		reqUserWrapperDto.setTotal(totalCount);
		reqUserWrapperDto.setReqUsers(createRequestedForUserDto);

		return reqUserWrapperDto;
	}


}
