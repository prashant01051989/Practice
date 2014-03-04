package com.ironmountain.recordcenter.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.types.BusinessObjectEnum;
import com.ironmountain.common.types.ScreenTypeEnum;
import com.ironmountain.common.types.ServiceStatus;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.dataaccess.rc2db.user.RcUserDao;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.user.RCUserFavDef;
import com.ironmountain.dto.address.CustomerAddressDefaultDto;
import com.ironmountain.dto.user.RCUserFavDefResultDto;
import com.ironmountain.dto.user.UserAddressesSummaryWrapperDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.rest.CoreServicesInvoker;
import com.ironmountain.recordcenter.service.RC2PersonalizationService;
import com.ironmountain.recordcenter.service.UserAddressService;


@Controller
public class UserAddressController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserAddressController.class);

	@Autowired
	private UserAddressService userAddressService;

	
	@Autowired
	private IronMountainMapper objectMapper;

	@Autowired
	private RC2PersonalizationService rc2PersonalizationService;

	@Autowired
	private CoreServicesInvoker invoker;	

	@Autowired
	private RcUserDao rcUserDao;
	
	@RequestMapping(value = "/api/app/users/{userId}/address/{addressId}/default", method = RequestMethod.POST)
	public @ResponseBody
	RCUserFavDefResultDto setDefaultAddress(@PathVariable String userId, @PathVariable String addressId) {

		LOGGER.debug("Request param [addressId=" + addressId + "]");
		LOGGER.debug("Request param [userId=" + userId + "]");

		RCUserFavDefResultDto resultDto = null;

		try {
			ServiceResult<RCUserFavDef> serviceResult = userAddressService.setDefaultAddress(Long.valueOf(userId), addressId);
			resultDto = objectMapper.map(serviceResult, RCUserFavDefResultDto.class);

			if (serviceResult.getStatus()== ServiceStatus.PASSED) {
				resultDto.getObj().setUri("/app/users/" + userId + "/address/" + addressId + "/default/" + serviceResult.getObj().getId());
			}

			if (serviceResult.getStatus()== ServiceStatus.FAILED) {
				resultDto.setResource(null);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception when setting Default Address", ex);
			throw new RuntimeException(ex);
		}
		return resultDto;
	}

	@RequestMapping(value = "/api/app/users/{userId}/address/{addressId}/favorite", method = RequestMethod.POST)
	public @ResponseBody
	RCUserFavDefResultDto addAddressToFavorite(@PathVariable String userId, @PathVariable String addressId) {

		LOGGER.debug("Request param [addressId=" + addressId + "]");
		LOGGER.debug("Request param [userId=" + userId + "]");

		RCUserFavDefResultDto resultDto = null;

		try {
			ServiceResult<RCUserFavDef> serviceResult = userAddressService.addAddressToFavorites(Long.valueOf(userId), addressId);

			resultDto = objectMapper.map(serviceResult, RCUserFavDefResultDto.class);

			if (serviceResult.getStatus() == ServiceStatus.PASSED) {
				resultDto.getObj().setUri("/app/users/" + userId + "/address/" + addressId + "/favorite/" + serviceResult.getObj().getId());
			}

			if (serviceResult.getStatus() == ServiceStatus.FAILED) {
				resultDto.setResource(null);
			}
		} catch (Exception ex) {
			LOGGER.error("Exception when adding Address to Favorite", ex);
			throw new RuntimeException(ex);
		}
		return resultDto;
	}

	@RequestMapping(value = "/api/app/address/default/{userDefaultId}", method = RequestMethod.DELETE)
	public @ResponseBody
	RCUserFavDefResultDto removeDefaultAddress(@PathVariable String userDefaultId) {
		LOGGER.debug("Request param [userDefaultId=" + userDefaultId + "]");
		RCUserFavDefResultDto resultDto = null;

		try {
			ServiceResult<RCUserFavDef> serviceResult = userAddressService.removeDefaultAddress(Long.valueOf(userDefaultId));
			resultDto = objectMapper.map(serviceResult, RCUserFavDefResultDto.class);

			if (serviceResult.getStatus()== ServiceStatus.PASSED) {
				resultDto.getObj().setUri(
						"/app/users/" + serviceResult.getObj().getUserId() + "/address/" + serviceResult.getObj().getObjectId() + "/default/"
								+ serviceResult.getObj().getId());
			}
			if (serviceResult.getStatus()== ServiceStatus.FAILED) {
				resultDto.setResource(null);
			}
		} catch (Exception ex) {
			LOGGER.error("Exception when removing default Address ", ex);
			throw new RuntimeException(ex);
		}

		return resultDto;
	}

	@RequestMapping(value = "/api/app/address/favorite/{userFavoriteId}", method = RequestMethod.DELETE)
	public @ResponseBody
	RCUserFavDefResultDto removeAddressFromFavorite(@PathVariable String userFavoriteId) {

		LOGGER.debug("Request param [userFavoriteId=" + userFavoriteId + "]");
		RCUserFavDefResultDto resultDto = null;
		try {
			ServiceResult<RCUserFavDef> serviceResult = userAddressService.removeAddressFromFavorites(Long.valueOf(userFavoriteId));

			resultDto = objectMapper.map(serviceResult, RCUserFavDefResultDto.class);

			if (serviceResult.getStatus()== ServiceStatus.PASSED) {
				resultDto.getObj().setUri(
						"/app/users/" + serviceResult.getObj().getUserId() + "/address/" + serviceResult.getObj().getObjectId() + "/favorite/"
								+ serviceResult.getObj().getId());
			}
			if (serviceResult.getStatus() ==ServiceStatus.FAILED) {
				resultDto.setResource(null);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception when removing Favorite Address ", ex);
			throw new RuntimeException(ex);
		}

		return resultDto;
	}
	
	@RequestMapping(value = RecordCenterUriFormats.RECORDS_MANAGEMENT_PATH + "/companies/{companyId}/customers/{customerId}/customerAddresses", method = RequestMethod.GET)
	public @ResponseBody UserAddressesSummaryWrapperDto handleCustomerAddressesRequest(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userId", required = false)  final Long userId,
			@PathVariable String companyId, @PathVariable String customerId,
			@RequestParam(value="startIndex", required=false) final Integer start,
			@RequestParam(value="limit", required=false) final Integer limit,
			@RequestParam(value="filterFields", required=false) final String filterFields,
			@QueryParam("sortField") @DefaultValue("") final String sortField,
			@QueryParam("sortBy") @DefaultValue("") final String sortBy ){
		
		
		//Cache based on filter,sort column and order strings as well.
		String cacheKeyForFilter = "";
		if(filterFields!=null){
			cacheKeyForFilter = filterFields;
		}
		UserAddressesSummaryWrapperDto userAddressesSummaryWrapperDto = userAddressService.getAllCustomerAddresses(request,
				response, userId, companyId, customerId, start, limit,
				filterFields,cacheKeyForFilter,sortField,sortBy); 
		
		return  userAddressService.getCustomerAddresses(userAddressesSummaryWrapperDto , request, response, userId, companyId, customerId, start, limit );
		
	}


	@RequestMapping(value = "/api/app/users/{userId}/defaultAddress", method = RequestMethod.GET)
	public @ResponseBody
	CustomerAddressDefaultDto getDefaultAddressbyUniqueId(@PathVariable String userId, HttpServletRequest request) {

		LOGGER.debug("Request param [userId=" + userId + "]");

		RCUserFavDef rcUserDef = null;
		CustomerAddressDefaultDto customerAddressDefaultDto = new CustomerAddressDefaultDto();

		try {

			rcUserDef = rc2PersonalizationService.getUsersScreenDefault(Long.valueOf(userId), ScreenTypeEnum.ADDGR, BusinessObjectEnum.ADDRESS);
			if(rcUserDef != null) {
				String uniqueId = rcUserDef.getObjectId();
				String companyId = ""+rcUserDao.getUserProfile(request.getHeader("iv-user")).getCompanyId();
				customerAddressDefaultDto = invoker.getAddressById(companyId, request.getHeader("iv-user"), uniqueId);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception when setting Default Address", ex);
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return customerAddressDefaultDto;
	}	


}
