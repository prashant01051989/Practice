package com.ironmountain.recordcenter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.common.exception.SecurityException;
import com.ironmountain.common.types.OrderLineItemTypeEnum;
import com.ironmountain.common.types.OrderTypeEnum;
import com.ironmountain.common.types.RetrievalMethodEnum;
import com.ironmountain.common.types.CartTypeEnum;
import com.ironmountain.common.types.ServiceStatus;
import com.ironmountain.common.uriframework.IronMountainMapper;
import com.ironmountain.domain.dto.common.ServiceResult;
import com.ironmountain.domain.orm.rc2db.cart.CartHeader;
import com.ironmountain.dto.order.CartHeaderOrder;
import com.ironmountain.dto.order.CartOrderResultDto;
import com.ironmountain.dto.order.OrderDtoRest;
import com.ironmountain.dto.order.OrderLineDtoRest;
import com.ironmountain.dto.order.OrderResultDto;
import com.ironmountain.dto.order.OrderResultWrapperDto;
import com.ironmountain.dto.orgs.customer.CustomerDtoLink;
import com.ironmountain.dto.utils.UriFormats;
import com.ironmountain.recordcenter.service.cart.CartLineHeaderService;
import com.ironmountain.recordcenter.service.cart.CartService;
import com.ironmountain.recordcenter.service.cart.RetrievalCartLineService;
import com.ironmountain.recordcenter.service.order.OrderRequest;
import com.ironmountain.recordcenter.service.order.OrderService;

@Controller
@RequestMapping(value = UriFormats.SERVICES_ROOT + UriFormats.ORDER_PROCESS_QUEUE)
public class OrderController {
    private final static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IronMountainMapper objectMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartLineHeaderService cartLineHeaderService;
    @Autowired
    private RetrievalCartLineService retrievalCartLineService;
    @Autowired
  	private CartService cartService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    CartOrderResultDto createOrderFromCart(@PathVariable String userId,
            @RequestBody OrderRequest orderRequest) {

        List<ServiceResult<CartHeaderOrder>> orders = orderService.covertToOrders(userId,
                orderRequest.getCartId());
        CartOrderResultDto cartOrderResult = new CartOrderResultDto();

        if (orders == null || orders.isEmpty()) {
        	throw new SecurityException("No valid items were found in the cart. Your access may have changed since adding items. Please contact your systems administrator");
        } else {
        	for (ServiceResult<CartHeaderOrder> cartHeaderOrderResult : orders) {

        		CartHeaderOrder cartHeaderOrder = cartHeaderOrderResult.getObj();
        		String companyId;
        	 	if (cartHeaderOrder.getCartHeader() == null) {
        			companyId = "Unknown";
        		} else {
        			companyId = cartHeaderOrder.getCartHeader().getCompanyId().toString();
        		}
        		OrderResultWrapperDto orderResultWrapper = new OrderResultWrapperDto();

        		OrderDtoRest order = cartHeaderOrder.getOrder();
        		if (cartHeaderOrder.getCustomer() != null) {
        			orderResultWrapper.setCustomer(objectMapper.map(cartHeaderOrder.getCustomer(),
        					CustomerDtoLink.class));
        		}

        		if (order == null) {
        			if (cartHeaderOrder.getCartHeader() == null) {
        				orderResultWrapper.setOrderType(OrderTypeEnum.RETRIEVAL);  //default to retrieval
        			} else {
        				if (cartHeaderOrder.getCartHeader().getCartType() == CartTypeEnum.RET) {
        					if (cartHeaderOrder.getCartHeader().getRetrievalMethod() == RetrievalMethodEnum.PW) {
        						orderResultWrapper.setOrderType(OrderTypeEnum.PERMANENT_WITHDRAWAL);
        					} else {
        						orderResultWrapper.setOrderType(OrderTypeEnum.RETRIEVAL);
        					}
        				}
        			}
        		} else {
        			orderResultWrapper.setOrderType(order.getOrderType());
        			setLineCounts(orderResultWrapper, order);       			
        		}
        		OrderResultDto resultDto = null;
        		if (cartHeaderOrderResult.hasError()) {
        			resultDto = new OrderResultDto();
       				resultDto.setErrors(cartHeaderOrderResult.getErrors());
       				resultDto.setWarnings(cartHeaderOrderResult.getWarnings());
       				resultDto.setStatus(cartHeaderOrderResult.getStatus());
       			} else {
       				resultDto = orderService.submitOrder(companyId, order);
        				if (resultDto != null
        						&& (resultDto.getStatus() == ServiceStatus.PASSED || resultDto.getStatus() == ServiceStatus.PASSED_WITH_WARNINGS)) {
        				deleteCartHeader(cartHeaderOrder);        				
        				cartService.clearCartOrderDetails(userId,orderRequest.getCartId(), cartHeaderOrder.getCartHeader().getCartType());
        			}
        		}

        		orderResultWrapper.setResult(resultDto);
        		cartOrderResult.getOrderResultList().add(orderResultWrapper);
        	}
        } 
        return objectMapper.map(cartOrderResult, CartOrderResultDto.class);
    }

    private void deleteCartHeader(CartHeaderOrder cartHeaderOrder) {
        CartHeader header = cartHeaderOrder.getCartHeader();
        try {
            if (cartHeaderOrder.isAllItemsSelected()) {
                cartLineHeaderService.deleteHeader(header.getHeaderId().toString(), header
                        .getCartId().toString(), header.getCartType().toString(), cartHeaderOrder
                        .getUserId());
            } else {
                for (OrderLineDtoRest orderline : cartHeaderOrder.getOrder().getOrderLines()) {
                    retrievalCartLineService.deleteCartLine(null, header.getCartId(),
                            header.getHeaderId(), header.getCartType().toString(),
                            (long) orderline.getOrderLineNumber(), cartHeaderOrder.getUserId());
                }
            }
        } catch (Exception e) {
            LOG.warn("Failed to remove header from cart: header=" + header, e);
        }
    }

    private void setLineCounts(OrderResultWrapperDto orderResultWrapper, OrderDtoRest order) {
        int boxCount = 0;
        int fileCount = 0;
        for (OrderLineDtoRest loneDto : order.getOrderLines()) {
            if (loneDto.getItemType() == OrderLineItemTypeEnum.FILE) {
                fileCount++;
            } else {
                boxCount++;
            }
        }
        orderResultWrapper.setOrderBoxCount(boxCount);
        orderResultWrapper.setOrderFileCount(fileCount);
        orderResultWrapper.setOrderLineCount(fileCount + boxCount);
    }
}
