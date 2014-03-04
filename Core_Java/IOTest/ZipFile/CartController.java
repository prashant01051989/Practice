package com.ironmountain.recordcenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.types.CartAddressTypeEnum;
import com.ironmountain.common.types.CartTypeEnum;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.cart.CartTypes;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.cart.Cart;
import com.ironmountain.domain.orm.rc2db.cart.CartAddress;
import com.ironmountain.domain.orm.rc2db.cart.CartEmail;
import com.ironmountain.domain.orm.rc2db.cart.CartHeader;
import com.ironmountain.domain.orm.rc2db.cart.CartHeaderWrapper;
import com.ironmountain.domain.orm.rc2db.key.CartAddressPK;
import com.ironmountain.domain.orm.rc2db.key.CartEmailPK;
import com.ironmountain.dto.address.CustomerAddressDefaultDto;
import com.ironmountain.dto.address.DeliveryAddressDto;
import com.ironmountain.dto.cart.CartDto;
import com.ironmountain.dto.cart.CartHeaderDto;
import com.ironmountain.dto.cart.CartHeaderWrapperDto;
import com.ironmountain.dto.cart.RcSupplyDto;
import com.ironmountain.dto.cart.SupplyCartLineDto;
import com.ironmountain.dto.cart.VolumePickupCartLineDto;
import com.ironmountain.dto.i18n.IMLocaleContext;
import com.ironmountain.dto.newcart.CartEmailDto;
import com.ironmountain.dto.newcart.CartSummaryDto;
import com.ironmountain.dto.newcart.CartSummaryResultDto;
import com.ironmountain.dto.newcart.CartTypesBaseDto;
import com.ironmountain.dto.newcart.CartTypesDto;
import com.ironmountain.dto.newcart.CartTypesSummaryDto;
import com.ironmountain.dto.order.OrderDetailsDto;
import com.ironmountain.dto.order.ShippingInfoDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.cart.CartService;
import com.ironmountain.recordcenter.service.util.I18nRcMessageUtil;

/**
 * This controller class is responsible for operations like GET, POST and PUT on
 * CART_TYPES and CART Any operations related to CART LINE HEADER should be
 * dealt in {@link CartLineHeaderController} Any operations related to CART LINE
 * ITEM should be dealt in {@link CartLineItemController}
 */
@Controller
@RequestMapping(value = RecordCenterUriFormats.USER_CARTS)
public class CartController {
	
	private final static Logger LOG = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@Autowired
	private IronMountainMapper objectMapper;

	@Autowired
	private I18nRcMessageUtil messageUtil;
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	CartTypesBaseDto getAllCartTypes(@PathVariable String userId, @RequestParam(defaultValue = "true") boolean abbreviated,
			@RequestParam(defaultValue = "false") boolean createDefault) {
		LOG.debug("getAllCartTypes UserId = [" + userId + "] abbreviated=" + abbreviated + " createDefault=" + createDefault);
		CartTypes cartTypesResult = cartService.getAllCartTypes(userId, createDefault);
		CartTypesBaseDto cartTypesDto;
		if (abbreviated) {
			cartTypesDto = objectMapper.map(cartTypesResult, CartTypesSummaryDto.class);
		} else {
			cartTypesDto = objectMapper.map(cartTypesResult, CartTypesDto.class);
		}
		return cartTypesDto;
	}
	
	
	@RequestMapping(value ="/reset",method = RequestMethod.GET)
	public void resetAllCarts(@PathVariable String userId){
		cartService.resetcarts(userId);
	}

	@RequestMapping(value = "/{cartType}", method = RequestMethod.POST)
	public @ResponseBody
	CartSummaryResultDto createEmptyCart(@PathVariable String userId, @PathVariable String cartType, @RequestBody CartSummaryDto cartDto) {
		ServiceResult<Cart> result = new ServiceResult<Cart>();
		CartTypeEnum type = CartTypeEnum.fromString(cartType);
		if (type != null) {
			Cart newCart = cartService.createCart(userId, type, cartDto.getIsDefault());
			if (newCart != null) {
				result = new ServiceResult<Cart>(newCart);
			}
		}
		return objectMapper.map(result, CartSummaryResultDto.class);
	}

	@RequestMapping(value = "/{cartType}/{cartId}", method = RequestMethod.DELETE)
	public @ResponseBody
	CartSummaryResultDto deleteCart(@PathVariable String userId, @PathVariable("cartType") String cartType, @PathVariable("cartId") long cartId) {
		ServiceResult<Cart> result = new ServiceResult<Cart>();
		CartTypeEnum type = CartTypeEnum.fromString(cartType);
		if (type != null) {
			Cart oldCart = cartService.deleteCart(userId, cartId, type);
			if (oldCart != null && oldCart.getCartType() == type) {
				result = new ServiceResult<Cart>(oldCart);
			} else {
				throw new EntityNotFoundException("Cart type [" + cartType + "] cart id [" + cartId + "] not found");
			}
		}
		return objectMapper.map(result, CartSummaryResultDto.class);
	}

	@RequestMapping(value = "/{cartType}/{cartId}", method = RequestMethod.GET)
	public @ResponseBody
	CartDto getCart(@PathVariable String userId, @PathVariable String cartType, @PathVariable long cartId) {
		LOG.info("Request param [cartId=" + cartId + "]");
		LOG.info("Request param [userId=" + userId + "]");
		LOG.info("Request param [cartTypes=" + cartType + "]");

		CartTypeEnum type = CartTypeEnum.fromString(cartType);
		Cart cart = cartService.getCart(userId,cartId,CartTypeEnum.fromString(cartType));
		if (cart == null) {

			throw new EntityNotFoundException("Cart type [" + cartType + "] cart id [" + cartId + "] not found");
		}
		if (cart.getCartType() != type) {

			throw new EntityNotFoundException("Cart type [" + cartType + "] cart id [" + cartId + "] not found");
		}
		CartDto cartDto = objectMapper.map(cart, CartDto.class);
		if (type == CartTypeEnum.SUPP) {
			translateRcSupplyLines(cartDto);
		} else {
			if (type == CartTypeEnum.VOL_PICKUP) {
				setTitleOnVPLines(cartDto);
			}
		}
		OrderDetailsDto detailsDto = objectMapper.map(cartService.getCartOrderDetails(userId, cart), OrderDetailsDto.class);
		detailsDto.setBaseUri(null);
		cartDto.setOrderDetails(detailsDto);
		return cartDto;
	}

	@RequestMapping(value = "/{cartType}/{cartId}", method = RequestMethod.PUT)
	public @ResponseBody
	CartSummaryResultDto updateCart(@PathVariable String userId, @PathVariable String cartType, @PathVariable long cartId,
			@RequestBody CartDto cartDto) {
		Cart cart = null;
		cart = objectMapper.map(cartDto, Cart.class);
		// TODO : Below code is required as URI framework is not copying
		// headerId to CartHeader and customer information from CartHeaderDto
		CartHeaderWrapperDto cartHeaderWrapperDto = cartDto.getCartHeaderWrapper();
		if (cartHeaderWrapperDto != null) {
			CartHeaderWrapper cartHeaderWrapper = new CartHeaderWrapper();
			List<CartHeaderDto> cartHeaderList = cartHeaderWrapperDto.getCartHeaderList();
			if (CollectionUtils.isNotEmpty(cartHeaderList)) {
				List<CartHeader> headerList = new ArrayList<CartHeader>();
				for (CartHeaderDto cartHeaderDto : cartHeaderList) {
					CartHeader cartHeader = objectMapper.map(cartHeaderDto, CartHeader.class);
					headerList.add(cartHeader);
				}
				cartHeaderWrapper.setEntityList(headerList);
				cart.setCartHeaderWrapper(cartHeaderWrapper);
			}
		}
		// Will remove the above code once the issue is fixed.

		cart.setCartId(cartId);
		mergeCartOrderInfo(cartDto.getOrderDetails(), cart);
		return objectMapper.map(cartService.updateCart(userId, cart), CartSummaryResultDto.class);
	}

	@RequestMapping(value = "/{cartType}/{cartId}/orderDetails", method = RequestMethod.PUT)
	public @ResponseBody
	CartSummaryResultDto updateCartOrderDetails(@PathVariable String userId, @PathVariable String cartType, @PathVariable long cartId,
			@RequestBody OrderDetailsDto detailsDto) {
		Cart cart = cartService.getCart(userId,cartId,CartTypeEnum.fromString(cartType));
		mergeCartOrderInfo(detailsDto, cart);
		return objectMapper.map(cartService.updateCart(userId, cart), CartSummaryResultDto.class);
	}

	private void mergeCartOrderInfo(OrderDetailsDto detailsDto, Cart cart) {
		if (detailsDto != null) {
			if (detailsDto.getEmails() != null) {
				updateCartEmails(cart, detailsDto.getEmails().getEmailList());
			}
			cart.setOrderInstructions(detailsDto.getOrderInstructions());
			if (detailsDto.getDeliveryAddress() != null || detailsDto.getInternalRoutingAddress() != null) {
				List<CartAddress> cartAddresses = new ArrayList<CartAddress>();
				addCartAddressToList(cartAddresses, cart.getCartId(), detailsDto.getDeliveryAddress(), CartAddressTypeEnum.DELIVERY);
				addCartAddressToList(cartAddresses, cart.getCartId(), detailsDto.getInternalRoutingAddress(), CartAddressTypeEnum.INTERNAL_ROUTING);
				cart.setAddresses(cartAddresses);
			}
			ShippingInfoDto shippingInfo = detailsDto.getShippingInfo();
			if (shippingInfo != null) {
				cart.setCarrierCode(shippingInfo.getCarrierCode());
				String dp = shippingInfo.getDeliveryPriority();
				if (StringUtils.isNotBlank(dp)) {
					cart.setDeliveryPriority(dp.charAt(0));
				}
				cart.setDeliveryTimeFormat(shippingInfo.getDeliveryTimeFormat());
				cart.setCarrierThirdPty(shippingInfo.getThirdPartyCarrierName());
				cart.setCarrierThirdPtyPriority(shippingInfo.getThirdPartyCarrierPriority());
				cart.setCarrierThirdPtyAccount(shippingInfo.getThirdPartyCarrierAccount());
			}
		}
	}

	private void updateCartEmails(Cart cart, List<CartEmailDto> emailDtoList) {
		if (emailDtoList == null) {
			return;
		}
		List<CartEmail> emailList = new ArrayList<CartEmail>();
		int lineNo = 0;
		for (CartEmailDto cartEmailDto : emailDtoList) {
			CartEmail cartEmail = new CartEmail();
			cartEmail.setEmailId(cartEmailDto.getEmailId());
			cartEmail.setEmailPK(new CartEmailPK(cart.getCartId(), lineNo++));
			cartEmail.setPrimary(cartEmailDto.isPrimary() ? 1 : 0);
			emailList.add(cartEmail);
		}
		cart.setEmails(emailList);
	}

	private void addCartAddressToList(List<CartAddress> cartAddresses, Long cartId, DeliveryAddressDto dAddrDto, CartAddressTypeEnum addressType) {
		if (dAddrDto != null) {
			CustomerAddressDefaultDto custAddr = dAddrDto.getAddress();
			if (custAddr == null) {
				return;
			}
			CartAddress cartAddress = new CartAddress();
			cartAddress.setUniqueAddressId(custAddr.getUniqueAddressId());
			cartAddress.setAddressLine2(dAddrDto.getAddress2());
			cartAddress.setAddressLine3(dAddrDto.getAddress3());
			cartAddress.setContactName(dAddrDto.getContactName());
			cartAddress.setContactPhone(dAddrDto.getContactPhone());
			cartAddress.setAddressType(addressType.toString().charAt(0));
			CartAddressPK addrPK = new CartAddressPK(cartId, cartAddresses.size());
			cartAddress.setAddressPK(addrPK);
			cartAddresses.add(cartAddress);
		}
	}

	private void translateRcSupplyLines(CartDto cartDto) {
		if (cartDto.getCartHeaderWrapper() != null && cartDto.getCartHeaderWrapper().getCartHeaderList() != null) {
			final String locale = ((IMLocaleContext) LocaleContextHolder.getLocaleContext()).getLocale().toString();
			for (CartHeaderDto cartHeaderDto : cartDto.getCartHeaderWrapper().getCartHeaderList()) {
				if (cartHeaderDto.getSupplyCartLineWrapper() != null && cartHeaderDto.getSupplyCartLineWrapper().getSupplyCartLineList() != null) {
					for (SupplyCartLineDto supplyCartLineDto : cartHeaderDto.getSupplyCartLineWrapper().getSupplyCartLineList()) {
						translateRcSupply(supplyCartLineDto.getSupplyDetails(), locale);
					}
				}
			}
		}
	}

	private void translateRcSupply(RcSupplyDto rcSupply, String locale) {
		if (rcSupply != null) {
			String[] args = new String[0];
			String messageText = null;
			if (rcSupply.getDescription() != null) {
				messageText = messageUtil.getMessageString(rcSupply.getDescription(), locale, args);
				if (messageText != null) {
					rcSupply.setDescription(messageText);
				}
			}
			if (rcSupply.getLongdescription() != null) {
				messageText = messageUtil.getMessageString(rcSupply.getLongdescription(), locale, args);
				if (messageText != null) {
					rcSupply.setLongdescription(messageText);
				}
			}
			if (rcSupply.getRedcolortext() != null) {
				messageText = messageUtil.getMessageString(rcSupply.getRedcolortext(), locale, args);
				if (messageText != null) {
					rcSupply.setRedcolortext(messageText);
				}
			}
		}
	}
	
	private void setTitleOnVPLines(CartDto cartDto) {
		if (cartDto.getCartHeaderWrapper() != null && cartDto.getCartHeaderWrapper().getCartHeaderList() != null) {
			final String locale = ((IMLocaleContext) LocaleContextHolder.getLocaleContext()).getLocale().toString();
			String[] args = new String[0];
			String messageText = null;
			for (CartHeaderDto cartHeaderDto : cartDto.getCartHeaderWrapper().getCartHeaderList()) {
				if (cartHeaderDto.getVolumePickupCartLineWrapper() != null && cartHeaderDto.getVolumePickupCartLineWrapper().getVolumePickUpCartLineList() != null) {
					for (VolumePickupCartLineDto vpCartLineDto : cartHeaderDto.getVolumePickupCartLineWrapper().getVolumePickUpCartLineList()) {
						String title = (vpCartLineDto).getAssetDetails().getDescription();
						messageText = messageUtil.getMessageString(title, locale, args);
						if (messageText != null) {
							title = messageText;
						}
						(vpCartLineDto).getAssetDetails().setTitle(title);           //Title should be set to assetType
					}
				}
			}
		}
	}

}
