package com.ironmountain.recordcenter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.exception.SecurityException;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.orm.rc2db.user.RcPickupAsset;
import com.ironmountain.domain.orm.rc2db.user.RcPickupAssetWrapper;
import com.ironmountain.dto.user.PickupAssetWrapperDto;
import com.ironmountain.dto.utils.UriFormats;
import com.ironmountain.recordcenter.common.HttpCommonUtils;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.PickupAssetListService;

@Controller
public class PickupAssetListController {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PickupAssetListController.class);

	@Autowired
	private PickupAssetListService pickupAssetService;
	
	@Autowired
	private HttpCommonUtils httpCommonUtils;

	@Autowired
	private IronMountainMapper objectMapper;

	@ResponseBody 
	@RequestMapping(value = UriFormats.SERVICES_ROOT + RecordCenterUriFormats.PICKUP_ASSET_URL, method = RequestMethod.GET)
	public PickupAssetWrapperDto handleUserPickupAssetListRequest(HttpServletRequest request, HttpServletResponse response) {
		PickupAssetWrapperDto pickupAssetWrprDto =  new PickupAssetWrapperDto();
		try {
			List<RcPickupAsset> rcPickupAssetList = pickupAssetService.getPickupAssetList();
			RcPickupAssetWrapper rcPickupAssetWrpr = new RcPickupAssetWrapper();
			rcPickupAssetWrpr.setPickupAssetList(rcPickupAssetList);
			pickupAssetWrprDto = objectMapper.map(rcPickupAssetWrpr, PickupAssetWrapperDto.class);
			pickupAssetWrprDto.setCount(pickupAssetWrprDto.getPickupAssetDtoList().size());
			pickupAssetWrprDto.setTotal(pickupAssetWrprDto.getPickupAssetDtoList().size());
		}
		catch(java.lang.SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		catch (Exception e) {
			LOGGER.error("Exception while getting user pickup asset list", e);
			throw new RuntimeException(e);
	    }
		pickupAssetWrprDto.setUri(RecordCenterUriFormats.PICKUP_ASSET_URL);
		pickupAssetWrprDto.setBaseUri(httpCommonUtils.buildBaseUri(request));
		return pickupAssetWrprDto;
	}
	
}
