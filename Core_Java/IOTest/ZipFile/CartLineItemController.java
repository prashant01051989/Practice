package com.ironmountain.recordcenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.exception.SecurityException;
import com.ironmountain.common.types.CartTypeEnum;
import com.ironmountain.common.types.ServiceStatus;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.dto.common.ValidationMessage;
import com.ironmountain.domain.orm.rc2db.cart.BaseCartLine;
import com.ironmountain.domain.orm.rc2db.cart.RetrievalCartLine;
import com.ironmountain.domain.orm.rc2db.cart.SupplyCartLine;
import com.ironmountain.domain.orm.rc2db.cart.VolumePickupCartLine;
import com.ironmountain.dto.cart.BaseCartLineDto;
import com.ironmountain.dto.cart.CartLineResultDto;
import com.ironmountain.dto.cart.CartLineWrapperDto;
import com.ironmountain.dto.cart.RetrievalCartLineDto;
import com.ironmountain.dto.cart.RetrievalCartLineResultDto;
import com.ironmountain.dto.cart.SupplyCartLineDto;
import com.ironmountain.dto.cart.SupplyCartLineResultDto;
import com.ironmountain.dto.cart.VolumePickupCartLineDto;
import com.ironmountain.dto.cart.VolumePickupCartLineResultDto;
import com.ironmountain.dto.i18n.IMLocaleContext;
import com.ironmountain.recordcenter.service.cart.CartLineService;
import com.ironmountain.recordcenter.service.cart.LineMapper;
import com.ironmountain.recordcenter.service.util.I18nRcMessageUtil;

/**
 * This controller class is responsible for operations like GET, POST and PUT on CART LINE ITEM
 * Any operations related to CART LINE HEADER should be dealt in {@link CartLineHeaderController}
 *  Any operations related to CART OR CART TYPE should be dealt in {@link CartController}
 */
@Controller
public class CartLineItemController {	
		
	private CartLineService cartLineService ;
	
	@Autowired
	private IronMountainMapper objectMapper;
	
	@Autowired
	private LineMapper lineMapper;
	
	@Autowired
	private I18nRcMessageUtil messageUtil;
	
	private static final Logger LOG = Logger.getLogger(CartLineItemController.class);	
	
	@RequestMapping(value = "/api/app/users/{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}/lines", method = RequestMethod.POST)
	public @ResponseBody CartLineResultDto addCartLine(@RequestBody CartLineWrapperDto cartLineWrapperDto,@PathVariable Long cartId,
			@PathVariable Long headerId, @PathVariable String cartTypes,@PathVariable String userId) {	
		
		BaseCartLine cartLine = null;
		ServiceResult<BaseCartLine>  retCartLine = null;		
		CartLineResultDto retCartLineResultDto = new CartLineResultDto();				
		CartTypeEnum cartTypeEnum = CartTypeEnum.fromString(cartTypes);
		
			switch (cartTypeEnum) {
				case RET:											
						includeCommonFields(cartLineWrapperDto.getRetrievalCartLineDto(), cartId,  headerId,  null,  cartTypeEnum);
						cartLineService = lineMapper.getLineService(CartTypeEnum.RET);	
						cartLine = objectMapper.map(cartLineWrapperDto.getRetrievalCartLineDto(), RetrievalCartLine.class);				 
						retCartLine = cartLineService.saveCartLine(cartLine, cartId, headerId,  cartTypes, userId);				
						retCartLineResultDto = objectMapper.map(retCartLine,RetrievalCartLineResultDto.class);
					break;
				case VOL_PICKUP:
						includeCommonFields(cartLineWrapperDto.getVolumePickupCartLineDto(), cartId,  headerId,  null,  cartTypeEnum);
						cartLineService = lineMapper.getLineService(CartTypeEnum.VOL_PICKUP);	
						cartLine = objectMapper.map(cartLineWrapperDto.getVolumePickupCartLineDto(), VolumePickupCartLine.class);	
						retCartLine = cartLineService.saveCartLine(cartLine, cartId, headerId,  cartTypes, userId);				
						retCartLineResultDto = objectMapper.map(retCartLine,VolumePickupCartLineResultDto.class);			
					break;
				case SUPP:
						includeCommonFields(cartLineWrapperDto.getSupplyCartLineDto(), cartId,  headerId,  null,  cartTypeEnum);
						cartLineService = lineMapper.getLineService(CartTypeEnum.SUPP);	
						cartLine = objectMapper.map(cartLineWrapperDto.getSupplyCartLineDto(), SupplyCartLine.class);
						retCartLine = cartLineService.saveCartLine(cartLine, cartId, headerId,  cartTypes, userId);
						retCartLineResultDto = objectMapper.map(retCartLine,SupplyCartLineResultDto.class);
					break;
				default:
					
			}
	   
		return retCartLineResultDto;
	}
	
	private void includeCommonFields(BaseCartLineDto baseCartLineDto,Long cartId, Long headerId, Long lineNumber, CartTypeEnum cartTypeEnum){
		baseCartLineDto.setCartId(cartId);
		baseCartLineDto.setCartType(cartTypeEnum);
		baseCartLineDto.setHeaderId(headerId);
		baseCartLineDto.setLineNumber(lineNumber);		
	}
	
	@RequestMapping(value = "/api/app/users/{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}/lines/{lineId}", method = RequestMethod.DELETE)
	public @ResponseBody CartLineResultDto deleteCartLine(@PathVariable Long cartId,
			@PathVariable Long headerId, @PathVariable String cartTypes, @PathVariable Long lineId,@PathVariable String userId) {	
		
		ServiceResult<BaseCartLine>  retCartLine = null;		
		CartLineResultDto retCartLineResultDto = new CartLineResultDto();
		CartTypeEnum cartTypeEnum = CartTypeEnum.fromString(cartTypes);
		BaseCartLine cartLine = null;	
							
			switch (cartTypeEnum) {
				case RET:
						cartLineService = lineMapper.getLineService(CartTypeEnum.RET);	
						retCartLine = cartLineService.deleteCartLine(cartLine, cartId, headerId,  cartTypes,   lineId,  userId);
						retCartLineResultDto = objectMapper.map(retCartLine,RetrievalCartLineResultDto.class);				
					break;
				case VOL_PICKUP:
						cartLineService = lineMapper.getLineService(CartTypeEnum.VOL_PICKUP);	
						retCartLine = cartLineService.deleteCartLine(cartLine, cartId, headerId,  cartTypes,   lineId,  userId);
						retCartLineResultDto = objectMapper.map(retCartLine,VolumePickupCartLineResultDto.class);								
					break;
				case SUPP:
						cartLineService = lineMapper.getLineService(CartTypeEnum.SUPP);	
						retCartLine = cartLineService.deleteCartLine(cartLine, cartId, headerId,  cartTypes,   lineId,  userId);
						retCartLineResultDto = objectMapper.map(retCartLine,SupplyCartLineResultDto.class);			
					break;			
				default:
					
			}												
			retCartLineResultDto.setStatus(ServiceStatus.PASSED);
		
		return retCartLineResultDto;
	}
	
	
	@RequestMapping(value = "/api/app/users/{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}/lines/{lineId}", method = RequestMethod.PUT)
	public @ResponseBody CartLineResultDto updateCartLine(@RequestBody CartLineWrapperDto cartLineWrapperDto,@PathVariable Long cartId,
			@PathVariable Long headerId, @PathVariable String cartTypes,@PathVariable String userId, @PathVariable Long lineId) {	
		
		BaseCartLine cartLine = null;
		ServiceResult<BaseCartLine>  retCartLine = null;		
		CartLineResultDto retCartLineResultDto = new CartLineResultDto();				
		CartTypeEnum cartTypeEnum = CartTypeEnum.fromString(cartTypes);						
			
			switch (cartTypeEnum) {
			case RET:
				    includeCommonFields(cartLineWrapperDto.getRetrievalCartLineDto(), cartId,  headerId,  lineId,  cartTypeEnum);
					cartLineService = lineMapper.getLineService(CartTypeEnum.RET);	
					cartLine = objectMapper.map(cartLineWrapperDto.getRetrievalCartLineDto(), RetrievalCartLine.class);
					retCartLine = cartLineService.updateCartLine(cartLine, cartId, headerId, cartTypes, lineId, userId);				
					retCartLineResultDto = objectMapper.map(retCartLine,RetrievalCartLineResultDto.class);
				break;
			case VOL_PICKUP:
					includeCommonFields(cartLineWrapperDto.getVolumePickupCartLineDto(), cartId,  headerId,  lineId,  cartTypeEnum);
					cartLineService = lineMapper.getLineService(CartTypeEnum.VOL_PICKUP);	
					cartLine = objectMapper.map(cartLineWrapperDto.getVolumePickupCartLineDto(), VolumePickupCartLine.class);
					retCartLine = cartLineService.updateCartLine(cartLine, cartId, headerId, cartTypes, lineId, userId);				
					retCartLineResultDto = objectMapper.map(retCartLine,VolumePickupCartLineResultDto.class);
				break;
			case SUPP:
					includeCommonFields(cartLineWrapperDto.getSupplyCartLineDto(), cartId,  headerId,  lineId,  cartTypeEnum);
					cartLineService = lineMapper.getLineService(CartTypeEnum.SUPP);	
					cartLine = objectMapper.map(cartLineWrapperDto.getSupplyCartLineDto(), SupplyCartLine.class);
					retCartLine = cartLineService.updateCartLine(cartLine, cartId, headerId, cartTypes, lineId, userId);
					retCartLineResultDto = objectMapper.map(retCartLine,SupplyCartLineResultDto.class);
				break;			
			default:
				
			}			
		
	
		return retCartLineResultDto;
	}
	
	
	@RequestMapping(value = "/api/app/users/{userId}/carts/{cartTypes}/{cartId}/lineHeaders/{headerId}/lines/{lineId}", method = RequestMethod.GET)
	public @ResponseBody BaseCartLineDto getCartLineItem(@PathVariable Long cartId,
			@PathVariable Long headerId, @PathVariable String cartTypes,@PathVariable String userId,@PathVariable Long lineId) 
	{		
		
		BaseCartLine cartLine = null;
		BaseCartLineDto baseCartLineDto = null;	
		CartTypeEnum cartTypeEnum = CartTypeEnum.fromString(cartTypes);	
			switch (cartTypeEnum) {
			case RET:
					cartLineService = lineMapper.getLineService(CartTypeEnum.RET);				 
					cartLine = cartLineService.getCartLine(cartId, headerId, cartTypes,  lineId, userId);					
					baseCartLineDto  =  objectMapper.map(cartLine, RetrievalCartLineDto.class);	
				break;
			case VOL_PICKUP:
					cartLineService = lineMapper.getLineService(CartTypeEnum.VOL_PICKUP);		
					cartLine = cartLineService.getCartLine(cartId, headerId, cartTypes,  lineId, userId);
					baseCartLineDto  =  objectMapper.map(cartLine, VolumePickupCartLineDto.class);
					((VolumePickupCartLineDto)baseCartLineDto).getAssetDetails().setUri(null);//Uri should not be displayed
					//Title should be set to assetType and translated
					String title = ((VolumePickupCartLineDto)baseCartLineDto).getAssetDetails().getDescription();
					final String locale = ((IMLocaleContext) LocaleContextHolder.getLocaleContext()).getLocale().toString();
					String[] args = new String[0];
					String messageText = null;
					messageText = messageUtil.getMessageString(title, locale, args);
					if (messageText != null) {
						title = messageText;
					}
					((VolumePickupCartLineDto)baseCartLineDto).getAssetDetails().setTitle(title);
				break;
			case SUPP:
					cartLineService = lineMapper.getLineService(CartTypeEnum.SUPP);		
					cartLine = cartLineService.getCartLine(cartId, headerId, cartTypes,  lineId, userId);	
					baseCartLineDto  =  objectMapper.map(cartLine, SupplyCartLineDto.class);
					((SupplyCartLineDto)baseCartLineDto).getSupplyDetails().setUri(null);//Uri should not be displayed
				break;			
			default:
				
			}						
		
		return baseCartLineDto;
	}
}
