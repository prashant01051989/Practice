package com.ironmountain.recordcenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.types.ServiceStatus;
import com.ironmountain.common.util.I18Util;
import com.ironmountain.domain.dto.common.SafMapper;
import com.ironmountain.domain.dto.common.SafMapperFactory;
import com.ironmountain.domain.dto.common.SafMapperFieldConverterImpl;
import com.ironmountain.domain.dto.common.SearchAndFilterDto;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.user.ChangeHistoryWrapper;
import com.ironmountain.domain.orm.rc2db.user.PermissionWrapper;
import com.ironmountain.domain.orm.rc2db.user.RcUser;
import com.ironmountain.domain.orm.rc2db.user.RcUserPreference;
import com.ironmountain.domain.orm.rc2db.user.Security;
import com.ironmountain.dto.common.EmptyServiceResultDto;
import com.ironmountain.dto.common.RestResourceServiceResultDto;
import com.ironmountain.dto.orgs.company.CompanyGrantsDto;
import com.ironmountain.dto.user.ChangeHistoryDto;
import com.ironmountain.dto.user.ChangeHistoryWrapperDto;
import com.ironmountain.dto.user.PermissionWrapperDto;
import com.ironmountain.dto.user.SecurityDto;
import com.ironmountain.dto.user.UserDto;
import com.ironmountain.dto.user.UserPreferenceDto;
import com.ironmountain.dto.user.UserPreferenceResultDto;
import com.ironmountain.dto.user.UserResultDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.rest.CoreServicesInvoker;
import com.ironmountain.recordcenter.service.UserService;
import com.ironmountain.recordcenter.service.audit.ChangeHistoryService;
import com.ironmountain.security.domain.CompanyGrants;
import com.ironmountain.security.service.accesscontrol.AccessControlEvictService;
import com.ironmountain.security.service.accesscontrol.AccessControlListService;


@Controller
public class UserController {

	public static final String POST_ENCODING = "UTF-8";

	
	private static final Logger LOG = org.slf4j.LoggerFactory
			.getLogger(UserController.class);
	
	@Autowired
	private CoreServicesInvoker invoker;


	@Autowired
	private UserService userService;
	
	@Autowired
	private AccessControlListService accessControlListService;
	
	@Autowired
	private AccessControlEvictService accessControlEvictService;
	
	@Autowired
	private com.ironmountain.common.uriframework.IronMountainMapper objectMapper;
	
	@Autowired
	private ChangeHistoryService changeHistoryService;
	
	
	static {
		// CustomSupplyHistWrapperDto -> CustomSupplyHistWrapper
		SafMapper safMapper = new SafMapper();
		safMapper.addFieldConverter("modifiedBy", new SafMapperFieldConverterImpl("modifiedBy.firstName"));
		SafMapperFactory.instance().addMapper(ChangeHistoryWrapperDto.class, ChangeHistoryWrapper.class, safMapper);
	}
	
	
	//This method is used by the UI to validate if the logged in user still part of a valid session
	//calls are made from the UI every 60 secs.
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody String showUser(HttpServletRequest request) {
		String searchResult = request.getUserPrincipal().getName();
		LOG.debug(searchResult);
		return searchResult;
	}

	
	@RequestMapping(value = RecordCenterUriFormats.USERS_ROOT + "/{userId}", method = RequestMethod.GET)
	public @ResponseBody UserDto getUser(@PathVariable("userId") String userId,HttpServletRequest request) {
 		RcUser user=userService.getUser(userId);	
 		UserDto userDto = objectMapper.map(user, UserDto.class,"remove-password");
 		
 		//TODO All the users now come from rc2 can we now change this to getUserID instead of relying on DB ids 
 		if(user.getId() != null) {
 			userDto.setDbId(user.getId().toString());
 		}

 		String timezoneID = user.getUserPreference().getLocalTimezone();
 		timezoneID = (timezoneID == null || "".equals(timezoneID)) ? "America/New_York" : timezoneID;
 		userDto.getUserProfile().getUserPreference().setGmtOffset(I18Util.getGMTOffset(timezoneID));
 		userDto.getUserProfile().getUserPreference().setLocalTimezone(I18Util.getLocalTimezone(timezoneID, user.getUserPreference().getDefaultLocale()));
 		return objectMapper.map(userDto, UserDto.class);
	}
	
	@RequestMapping(value = RecordCenterUriFormats.USERS_ROOT, method = RequestMethod.POST)
	public @ResponseBody UserResultDto createUser(@RequestBody UserDto userdto) {
		
		RcUser rcuser = objectMapper.map(userdto, RcUser.class);
		ServiceResult<RcUser> serviceResult = userService.createUser(rcuser);		
		 UserResultDto userResultDto = objectMapper.map(serviceResult, UserResultDto.class);
		 if(serviceResult.getStatus().equals(ServiceStatus.FAILED)){
			 userResultDto.setResource(null);
			}
		 return userResultDto;
	}
	
	@RequestMapping(value = RecordCenterUriFormats.USERS_ROOT, method = RequestMethod.PUT)
	public @ResponseBody UserResultDto updateUser(@RequestBody UserDto userdto) {
		
		RcUser rcuser = objectMapper.map(userdto, RcUser.class);
		ServiceResult<RcUser> serviceResult = userService.updateUser(rcuser);		
		 UserResultDto userResultDto = objectMapper.map(serviceResult, UserResultDto.class);
		 if(serviceResult.getStatus().equals(ServiceStatus.FAILED)){
			 userResultDto.setResource(null);
			}
		 return userResultDto;
	}

	@RequestMapping(value = RecordCenterUriFormats.USER_ROOT + "/permissions", method = RequestMethod.GET)
	public @ResponseBody PermissionWrapperDto listPermissions(@PathVariable("userId") String userId) {
		PermissionWrapper permissions=userService.getUserPermissions(userId);
		return objectMapper.map(permissions, PermissionWrapperDto.class);
	}
	
	@RequestMapping(value = RecordCenterUriFormats.USER_ROOT + "/security", method = RequestMethod.GET)
	public @ResponseBody SecurityDto userSecurity(@PathVariable("userId") String userId) {
		Security security=userService.getUserSecurity(userId);
		return objectMapper.map(security, SecurityDto.class);
	}

	@RequestMapping(value = "/authUser", method = RequestMethod.GET)
	public @ResponseBody UserDto getAuthUser(HttpServletRequest request) {
		return getUser(request.getUserPrincipal().getName(),request);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = RecordCenterUriFormats.APP_PATH + "/invalidateUserSession", method = RequestMethod.GET)
	public @ResponseBody ServiceResult invalidateUserSession(HttpServletRequest request){
		
		HttpSession appSession = request.getSession(false);
		if (appSession != null)
		{
			LOG.warn("Invalidating HttpSession!");
			appSession.invalidate();
			
		}
		
		ServiceResult serviceResult = new ServiceResult();
		serviceResult.setStatus(ServiceStatus.PASSED);
	    return 	serviceResult;
	}

	@RequestMapping(value = RecordCenterUriFormats.USER_ROOT + "/permissions", method = RequestMethod.POST)
	public @ResponseBody String addPermissions(HttpServletRequest request, @PathVariable("userId") String userId, @RequestBody PermissionWrapperDto permissionWrapper) {
		return userService.addUserPermissions(permissionWrapper.getPermissionList(), userId,  request.getUserPrincipal().getName());
				
	}
	
	@RequestMapping(value = RecordCenterUriFormats.USER_ROOT + "/permissions", method = RequestMethod.PUT)
	public @ResponseBody String updatePermissions(HttpServletRequest request, @PathVariable("userId") String userId, @RequestBody PermissionWrapperDto permissionWrapper) {
		return userService.updateUserPermissions(permissionWrapper.getPermissionList(), userId,  request.getUserPrincipal().getName());
				
	}
	
	@RequestMapping(value=RecordCenterUriFormats.USER_ROOT +"/security/companyGrants",method=RequestMethod.GET)
	public @ResponseBody CompanyGrantsDto getUserAccess(@PathVariable("userId") String userId){
		CompanyGrants companyGrants = new CompanyGrants();
		companyGrants.setCompanyProxyList(accessControlListService.getUserAccessOrgsWithParents(userId));		
		return objectMapper.map(companyGrants, CompanyGrantsDto.class);
	}
	
	@RequestMapping(value=RecordCenterUriFormats.USER_ROOT +"/security/companyGrants",method=RequestMethod.PUT)
	public @ResponseBody CompanyGrantsDto addUserAccess(@PathVariable("userId") String userId,@RequestBody CompanyGrantsDto companyGrantsDto){
		accessControlEvictService.evictAllUserCaches(userId);
		invoker.evictCacheInCoreServices(userId);
		return null;
	}
	
	@RequestMapping(value=RecordCenterUriFormats.SECURITY_HISTORIES ,method=RequestMethod.GET)
	public @ResponseBody ChangeHistoryWrapperDto getChangeHistories(@PathVariable("userId") String userId,SearchAndFilterDto safDto){
		SafMapperFactory.instance().map(ChangeHistoryWrapperDto.class, ChangeHistoryDto.class, safDto);
		return objectMapper.map(changeHistoryService.getChangeHistory(userId, safDto), ChangeHistoryWrapperDto.class);
	}

	@RequestMapping(value=RecordCenterUriFormats.USER_ROOT + "/preferences" ,method=RequestMethod.PUT)
	public @ResponseBody UserPreferenceResultDto putUserPreferences(@PathVariable("userId") String userId, @RequestBody UserPreferenceDto userPreferenceDto){
		ServiceResult<RcUserPreference> result = userService.updateUserPreference(userId, objectMapper.map(userPreferenceDto, RcUserPreference.class));
		return objectMapper.map(result, UserPreferenceResultDto.class);
	}
	
	@RequestMapping(value=RecordCenterUriFormats.USER_ROOT + "/companyId" ,method=RequestMethod.PUT)
	public @ResponseBody RestResourceServiceResultDto putSupportUserCompanyId(@PathVariable("userId") String userId, @RequestParam("companyId")String companyId, HttpServletRequest request){
		ServiceResult<String> result = null;
		result = userService.updateSupportUserCompanyId(userId, companyId);
		return objectMapper.map(result, EmptyServiceResultDto.class);
	}
	
	
}