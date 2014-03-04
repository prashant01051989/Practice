package com.ironmountain.recordcenter.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.exception.SecurityException;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.cart.CartHeader;
import com.ironmountain.domain.orm.rc2db.cart.CartHeaderWrapper;
import com.ironmountain.dto.cart.CartHeaderDto;
import com.ironmountain.dto.cart.CartHeaderResultDto;
import com.ironmountain.dto.cart.CartHeaderWrapperDto;
import com.ironmountain.recordcenter.service.cart.CartLineHeaderService;

/**
 * This controller class is responsible for operations like GET, POST and PUT on
 * CART LINE HEADERS Any operations related to CART OR CART TYPE should be dealt
 * in {@link CartController} Any operations related to CART LINE ITEM should be
 * dealt in {@link CartLineItemController}
 */
@Controller
public class CartLineHeaderController {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(CartLineHeaderController.class);

	public static final String CARTROOT = "/api/app/users/";

	@Autowired
	private CartLineHeaderService cartLineHeaderService;

	@Autowired
	private IronMountainMapper objectMapper;

	@RequestMapping(value = CARTROOT + "{userId}/carts/{cartTypes}/{cartId}/lineHeaders", method = RequestMethod.POST)
	public @ResponseBody
	CartHeaderResultDto addCartLineHeader(@PathVariable String userId, @PathVariable String cartTypes, @PathVariable String cartId,
			@RequestBody CartHeaderDto uiCartHeader) {
		logger.debug("Request param [cartId=" + cartId + "]");
		logger.debug("Request param [userId=" + userId + "]");
		logger.debug("Request param [cartTypes=" + cartTypes + "]");

		CartHeaderResultDto resultDto;
		CartHeader cartHeader = objectMapper.map(uiCartHeader, CartHeader.class);
		cartHeader.setCartId(Long.valueOf(cartId));
		ServiceResult<CartHeader> headerResult = cartLineHeaderService.createHeader(cartHeader, cartTypes, userId);
		resultDto = objectMapper.map(headerResult, CartHeaderResultDto.class);
		return resultDto;
	}

	@RequestMapping(value = CARTROOT + "{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}", method = RequestMethod.PUT)
	public @ResponseBody
	CartHeaderResultDto updateCartLineHeader(@PathVariable String userId, @PathVariable String cartTypes, @PathVariable String cartId,
			@PathVariable String headerId, @RequestBody CartHeaderDto uiCartHeader) {

		logger.debug("Request param [cartId=" + cartId + "]");
		logger.debug("Request param [userId=" + userId + "]");
		logger.debug("Request param [cartTypes=" + cartTypes + "]");

		CartHeaderResultDto resultDto = null;
		try {

			// This is to prevent from getting a security exception when there
			// is only an update made to the po number (can do it in a custom
			// converter of Dozer)
			if (uiCartHeader.getBillDiv() != null && uiCartHeader.getBillDiv().getGoatId().equals("null")) {
				uiCartHeader.getBillDiv().setGoatId(null);
			}

			// This is to prevent from getting a security exception when there
			// is only an update made to the po number
			if (uiCartHeader.getBillDept() != null && uiCartHeader.getBillDept().getGoatId().equals("null")) {
				uiCartHeader.getBillDept().setGoatId(null);
			}

			CartHeader cartHeader = objectMapper.map(uiCartHeader, CartHeader.class);
			cartHeader.setCartId(Long.valueOf(cartId));
			ServiceResult<CartHeader> headerResult = cartLineHeaderService.updateHeader(cartHeader, cartTypes, userId);
			resultDto = objectMapper.map(headerResult, CartHeaderResultDto.class);

		} 
		catch(java.lang.SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		catch(SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		return resultDto;

	}

	@RequestMapping(value = CARTROOT + "{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}", method = RequestMethod.DELETE)
	public @ResponseBody
	ServiceResult<CartHeader> deleteCartLineHeader(@PathVariable String userId, @PathVariable String cartTypes,
			@PathVariable String cartId, @PathVariable String headerId) {
		logger.debug("Request param [cartId=" + cartId + "]");
		logger.debug("Request param [userId=" + userId + "]");
		logger.debug("Request param [cartTypes=" + cartTypes + "]");
		logger.debug("Request param [headerId=" + headerId + "]");
		ServiceResult<CartHeader> deleteResult = null;
		try {

			deleteResult = cartLineHeaderService.deleteHeader(headerId, cartId, cartTypes, userId);

		} 
		catch(java.lang.SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		catch (Exception ex) {
			logger.error("Exception when deleting cart header.", ex);
			throw new RuntimeException(ex);
		}
		return deleteResult;

	}

	@RequestMapping(value = CARTROOT + "{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}", method = RequestMethod.GET)
	public @ResponseBody
	CartHeaderDto getCartLineHeader(@PathVariable String userId, @PathVariable String cartTypes, @PathVariable String cartId,
			@PathVariable String headerId) {

		logger.debug("Request param [cartId=" + cartId + "]");
		logger.debug("Request param [userId=" + userId + "]");
		logger.debug("Request param [cartTypes=" + cartTypes + "]");
		logger.debug("Request param [headerId=" + headerId + "]");
		CartHeaderDto cartHeaderDto;

		try {
			CartHeader cartHeader = cartLineHeaderService.getCartHeaderWithLines(headerId, cartId, cartTypes, userId);
			cartHeaderDto = objectMapper.map(cartHeader, CartHeaderDto.class);

		} 
		catch(java.lang.SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		catch (Exception ex) {
			logger.error("Exception when getting cart header.", ex);
			throw new RuntimeException(ex);
		}

		return cartHeaderDto;

	}

	@RequestMapping(value = CARTROOT + "{userId}/carts/{cartTypes}/{cartId}/lineHeaders", method = RequestMethod.GET)
	public @ResponseBody
	CartHeaderWrapperDto getCartLineHeaders(@PathVariable String userId, @PathVariable String cartTypes, @PathVariable String cartId) {

		logger.debug("Request param [cartId=" + cartId + "]");
		logger.debug("Request param [userId=" + userId + "]");
		logger.debug("Request param [cartTypes=" + cartTypes + "]");

		CartHeaderWrapperDto cartHeaderWrapperDto;

		try {
			ServiceResult<CartHeaderWrapper> cartHeadersResult  = cartLineHeaderService.getAllHeaders(cartId, cartTypes, userId);
			cartHeaderWrapperDto = objectMapper.map(cartHeadersResult.getObj(), CartHeaderWrapperDto.class);

		}
		catch(java.lang.SecurityException securityException){
			throw new SecurityException(securityException.getMessage());
		}
		catch (Exception ex) {
			logger.error("Exception when getting cart headers.", ex);
			throw new RuntimeException(ex);
		}
		return cartHeaderWrapperDto;

	}
}
