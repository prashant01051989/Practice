package com.ironmountain.recordcenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ironmountain.common.constants.AppConstants;
import com.ironmountain.domain.orm.rc2db.user.RcUser;
import com.ironmountain.dto.utils.UriFormats;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.UserService;

/**
 * Handles requests for the application's post-login landing page.
 */
@Controller
public class HomeController {

	private static final String HAPI_TIMEOUT = "60000"; // default hapi timeout
														// is 10s

	@Autowired
	private UserService userService;

	/**
	 * Selects the view to render by returning void and relying on the default
	 * request-to-view-translator.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView displayHome(HttpServletRequest request,
			@RequestParam(defaultValue = "true") boolean standalone, @RequestParam(required = false) String locale) {

		ModelAndView mav = new ModelAndView();
		String sessionLocale = populateLocaleContext(request, locale);
		String servicePath = "." + UriFormats.SERVICES_ROOT + "/";
		String hapiTimeout = System.getProperty("hapi.timeout");

		mav.addObject("hapiTimeout", hapiTimeout == null ? HAPI_TIMEOUT : hapiTimeout);
		mav.addObject("servicePath", servicePath);
		mav.addObject("standalone", standalone);
		mav.addObject("langBundleUri", "."+RecordCenterUriFormats.LOCALE_ROOT+"/"+sessionLocale);
		return mav;
	}

	/**
	 * This method will populate i18n context from user preference
	 */
	private String populateLocaleContext(HttpServletRequest request, String passedLocale) {
		SecurityContext context = SecurityContextHolder.getContext();
		HttpSession session = request.getSession(true);
		String timeZone = AppConstants.DEFAULT_TIMEZONE;
		String locale = AppConstants.DEFAULT_LOCALE;
		String language = locale.substring(0,2);

		if (context != null) {
			Authentication authentication = context.getAuthentication();

			if (authentication != null) {
				String userName = authentication.getName();
				RcUser user = userService.getUser(userName);

				if (user != null) {
					timeZone = user.getUserPreference().getLocalTimezone();
					timeZone = (timeZone == null || "".equals(timeZone)) ? AppConstants.DEFAULT_TIMEZONE : timeZone;
					locale = user.getUserPreference().getDefaultLocale();
					if ((passedLocale != null) && (!passedLocale.trim().isEmpty()) && (!passedLocale.equals(locale))) {
						user.getUserPreference().setDefaultLocale(passedLocale);
						userService.updateUserPreference(user.getUserPreference());
						locale = passedLocale;
					}

					locale = (locale == null || "".equals(locale)) ? AppConstants.DEFAULT_LOCALE : locale;

				}
			}
		}
		
		if (locale.length() == 5) {
			language = locale.substring(0, 2);
		}
		
		session.setAttribute("defaultLocale", locale);
		session.setAttribute("defaultLanguage", language);
		session.setAttribute("defaultTimezone", timeZone);

		return locale;
	}
}
