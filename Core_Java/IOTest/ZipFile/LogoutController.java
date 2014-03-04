package com.ironmountain.recordcenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application welcome page.
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

	public static final String POST_ENCODING = "UTF-8";
	private final Logger logger = org.slf4j.LoggerFactory
			.getLogger(LogoutController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request ) {
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info(userId+" Logout!");
		HttpSession appSession = request.getSession(false);
		if (appSession != null)
		{
			logger.warn("Invalidating HttpSession! "+ userId);
			appSession.invalidate();
			
		}
		return "logout";
		
	}
}
