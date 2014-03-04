package com.ironmountain.recordcenter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.constants.AppConstants;
import com.ironmountain.dto.asset.supplies.DistrictSupplyInputDto;
import com.ironmountain.dto.asset.supplies.DistrictSupplyInputWrapperDto;
import com.ironmountain.dto.asset.supplies.DistrictSupplyWrapperDto;
import com.ironmountain.dto.user.UserSupplyDto;
import com.ironmountain.dto.user.UserSupplyWrapperDto;
import com.ironmountain.dto.utils.UriFormats;
import com.ironmountain.recordcenter.common.HttpCommonUtils;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.rest.CoreServicesInvoker;
import com.ironmountain.recordcenter.service.CustomSupplyListService;
import com.ironmountain.recordcenter.service.UserSupplyListService;
import com.ironmountain.recordcenter.controller.util.SupplyListControllerUtil;

@Controller
public class UserSupplyListController {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserSupplyListController.class);

	@Autowired
	private UserSupplyListService userSplService;
	@Autowired
	private CustomSupplyListService customSplService;
	@Autowired
	private CoreServicesInvoker invoker;
	
	@Autowired
	private HttpCommonUtils httpCommonUtils;
	
	private static final String COMPANYIDVAR = "{companyId}";
	private static final String CUSTOMERIDVAR = "{customerId}";

	public @ResponseBody
	UserSupplyWrapperDto getUserSupplyList(HttpServletRequest request, HttpServletResponse response, final String companyId, final String customerId, final String districtId, Map<String,String> queryParams) {
		
		DistrictSupplyWrapperDto archSupWrprDto = null;
		UserSupplyWrapperDto userSupWrprDto =  new UserSupplyWrapperDto();
		DistrictSupplyInputWrapperDto districtSupWrpInput = new DistrictSupplyInputWrapperDto();
		try {
			List<String> customSupplies = customSplService.getCustomSuppliesForCustomer(customerId);
			boolean customSupplyConfigured = customSplService.isCustomSupplyListExists(customerId);
			if(customSupplyConfigured && (customSupplies == null || customSupplies.isEmpty()) ) {
				//return empty response
				List<UserSupplyDto> userSupplyDtoList = new ArrayList<UserSupplyDto>();
				String uri = UriFormats.CUSTOMER_SUPPLIES;
				uri = uri.replace(COMPANYIDVAR, companyId);
				uri = uri.replace(CUSTOMERIDVAR, customerId);
				
				userSupWrprDto.setRcSupplyDtoList(userSupplyDtoList);
				userSupWrprDto.setUri(uri);
				userSupWrprDto.setCount(0);
				userSupWrprDto.setTotal(0);
			} else {
				// call core services to get details
				List<DistrictSupplyInputDto> districtSuppies = new ArrayList<DistrictSupplyInputDto>();
				if (customSupplies != null && !customSupplies.isEmpty()) {
					for (String customSpl : customSupplies) {
						DistrictSupplyInputDto districtSplInput = new DistrictSupplyInputDto();
						districtSplInput.setGoatId(customSpl);
						districtSuppies.add(districtSplInput);
					}
					districtSupWrpInput.setSupplyList(districtSuppies);
				}
				String userId = SecurityContextHolder.getContext().getAuthentication().getName();
				districtSupWrpInput.setDistrictId(districtId);
				archSupWrprDto = invoker.getUserSupplyList(companyId, userId, customerId, districtSupWrpInput);
				userSupWrprDto = userSplService.createUserSupplyList(archSupWrprDto,queryParams);
			}
		}catch (Exception e) {
			LOGGER.error("Exception while getting user supply list", e);
			throw new RuntimeException(e);
	    }
		userSupWrprDto.setBaseUri(httpCommonUtils.buildBaseUri(request));
		return userSupWrprDto;
	}
	
	
	@RequestMapping(value = RecordCenterUriFormats.RECORDS_MANAGEMENT_PATH + "/companies/{companyId}/customers/{customerId}/supplies", method = RequestMethod.GET)
	public @ResponseBody UserSupplyWrapperDto handleUserSupplyListRequest(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("companyId") final String companyId, @PathVariable("customerId") final String customerId,
			@RequestParam("districtId") final String districtId,
			@RequestParam(value = SupplyListControllerUtil.START_INDEX, required = false) final Integer start,
			@RequestParam(value = SupplyListControllerUtil.LIMIT, required = false, defaultValue = AppConstants.DEFAULT_SEARCH_RESULTS_LIMIT) final Integer limit,
			@RequestParam(value = SupplyListControllerUtil.SORTBY, required = false, defaultValue = AppConstants.ORDER_BY_ASC) final String sortBy,
			@RequestParam(value = SupplyListControllerUtil.SORTFIELD, required = false) final String sortColumn,
			@RequestParam(value = SupplyListControllerUtil.FILTERFIELDS, required = false) final List<String> filterFields){
		return getUserSupplyList(request, response, companyId, customerId, districtId,SupplyListControllerUtil.getQueryParamsMap(start,limit,sortColumn,sortBy,filterFields));
	}
	
}
