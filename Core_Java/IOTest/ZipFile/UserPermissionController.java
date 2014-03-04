package com.ironmountain.recordcenter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.domain.orm.rc2db.user.PermissionWrapper;
import com.ironmountain.dto.user.PermissionResultDto;
import com.ironmountain.dto.user.PermissionWrapperDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.permission.PermissionService;

@Controller
public class UserPermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private com.ironmountain.common.uriframework.IronMountainMapper objectMapper;
	
	
	/**This method adds a permissions to the collections.It does not replace the existing collection.
	 * @param request
	 * @param userId
	 * @param permissionWrapper
	 * @return
	 */
	@RequestMapping(value = RecordCenterUriFormats.SECURITY_PERMISSIONS, method = RequestMethod.POST)
	public @ResponseBody PermissionResultDto addUserPermissions(HttpServletRequest request, @PathVariable("userId") String userId, @RequestBody PermissionWrapperDto permissionWrapperDto) {
		PermissionWrapper permissonWrapper = objectMapper.map(permissionWrapperDto, PermissionWrapper.class);
		return objectMapper.map(permissionService.updateUserPermissions(userId, permissonWrapper), PermissionResultDto.class);
	}
	
	/** This method would replace the permissions that are part of the permissions
	 * @param request
	 * @param userId
	 * @param permissionWrapper
	 * @return
	 */
	@RequestMapping(value = RecordCenterUriFormats.SECURITY_PERMISSIONS, method = RequestMethod.PUT)
	public @ResponseBody PermissionResultDto updateUserPermissions(HttpServletRequest request, @PathVariable("userId") String userId, @RequestBody PermissionWrapperDto permissionWrapperDto) {
		PermissionWrapper permissonWrapper = objectMapper.map(permissionWrapperDto, PermissionWrapper.class);
		return objectMapper.map(permissionService.replaceUserPermission(userId, permissonWrapper), PermissionResultDto.class);			
	}
	
	@RequestMapping(value = RecordCenterUriFormats.SECURITY_PERMISSIONS, method = RequestMethod.GET)
	public @ResponseBody PermissionWrapperDto getAllUserPermissions(@PathVariable("userId") String userId) {
		//PermissionWrapper permissions=userService.getUserPermissions(userId);
		//return objectMapper.map(permissions, PermissionWrapperDto.class);
		return null;
	}
	
	@RequestMapping(value = RecordCenterUriFormats.SECURITY_PERMISSIONS, method = RequestMethod.DELETE)
	public @ResponseBody PermissionWrapperDto removeAllUserPermissions(@PathVariable("userId") String userId) {
		return objectMapper.map(permissionService.deleteAllUserPermissions(userId),PermissionWrapperDto.class);
	}
	
	
	@RequestMapping(value = RecordCenterUriFormats.SECURITY_PERMISSIONS+"{permissionId}", method = RequestMethod.DELETE)
	public @ResponseBody PermissionWrapperDto removeSingleUserPermissions(@PathVariable("userId") String userId) {
		//PermissionWrapper permissions=userService.getUserPermissions(userId);
		//return objectMapper.map(permissions, PermissionWrapperDto.class);
		return null;
	}
	
	

}
