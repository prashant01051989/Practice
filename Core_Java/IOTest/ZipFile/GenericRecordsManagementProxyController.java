package com.ironmountain.recordcenter.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.recordcenter.common.HttpCommonUtils;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.service.proxy.ProxyHandler;
import com.ironmountain.service.proxy.ProxyRequest;
import com.ironmountain.service.proxy.ProxyResponse;
import com.ironmountain.service.proxy.ServiceInvocationException;
import com.ironmountain.service.proxy.util.ProxyUtility;

@Controller
@RequestMapping(value = RecordCenterUriFormats.RECORDS_MANAGEMENT_PATH)
public class GenericRecordsManagementProxyController {
	
	private static final Logger LOGGER = Logger.getLogger(GenericRecordsManagementProxyController.class);
	
	@Autowired
	private ProxyHandler handler;
	
	@Autowired
	private HttpCommonUtils httpCommonUtils;
	
	@Autowired
	private ProxyUtility proxyUtil;
	
	@Value("#{proxyproperties['weblink.services.absoluteurl']}")
	private String weblinkServicesFullUrl;
	

	// TODO - Using this URL Pattern to circumvent a bug in Spring 
	// https://jira.springsource.org/browse/SPR-8683
	@RequestMapping(value = "**/**/**/**/**/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
	public @ResponseBody String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServiceInvocationException{
		String responseObject;
		try {
			
			ProxyRequest proxyRequest = proxyUtil.createProxyRequest(request, weblinkServicesFullUrl);
			ProxyResponse proxyResponse = proxyUtil.proxyRequest(proxyRequest, handler);
			
			String responseBody = proxyResponse.getResponseBodyAsString();
					
			responseBody = httpCommonUtils.changeBaseUriOnResponse(request, responseBody);
			httpCommonUtils.handleResponseHeaders(response, proxyResponse.getHeader());
			response.setStatus(proxyResponse.getStatus());
			responseObject=responseBody;
 		} catch (Exception e) {
			
			LOGGER.error("Error in processing request", e);
			throw new ServiceInvocationException(e);
		}

		return  responseObject;
	}
	
	}