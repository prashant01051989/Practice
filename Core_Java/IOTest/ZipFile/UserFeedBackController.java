package com.ironmountain.recordcenter.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.domain.dto.user.UserFeedBackDto;
import com.ironmountain.recordcenter.service.UserFeedBackService;

@Controller
public class UserFeedBackController {
	
	@Autowired
	private UserFeedBackService userFeedBackService;
	
	
	private final Logger logger = org.slf4j.LoggerFactory
			.getLogger(UserFeedBackController.class);
	
	@RequestMapping(value="/users/{userId}/feedbacks/{feedbackId}", method=RequestMethod.GET)
    public @ResponseBody UserFeedBackDto saveUserFeedBack(@PathVariable("userId") String userId,@PathVariable("feedbackId") String feedbackId){
		return userFeedBackService.getUserFeedBackById(Long.valueOf(feedbackId));
    }

    
    @RequestMapping(value="/users/{userId}/feedbacks", method=RequestMethod.POST)
    public @ResponseBody UserFeedBackDto getUserFeedBack(@PathVariable("userId") String userId,@RequestBody UserFeedBackDto userFeedBack){
    	userFeedBack.setUserId(userId);
		//Added this check to consume feed back that does not hold any text : as the db clob is non nullable added a blank string
		//Not the right way to to do it but to stop making constant changes to the DDL a stopgap approach
		if(StringUtils.isBlank(userFeedBack.getFeedback())){
			userFeedBack.setFeedback(" ");
		}
		userFeedBackService.saveUserFeedBack(userFeedBack);
		logger.debug("FeedBack from user : "+userId+" added to the database and the feedback db id is : "+userFeedBack.getFeedbackId());
		return userFeedBack;
    }

	

}
