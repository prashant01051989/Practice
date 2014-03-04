package com.ironmountain.recordcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.domain.orm.rc2db.user.RcUser;
import com.ironmountain.dto.recordcenter.ApiDto;
import com.ironmountain.dto.recordcenter.AppDto;

@Controller
public class RecordCenterController {
	
	@Autowired
	private com.ironmountain.common.uriframework.IronMountainMapper objectMapper;
	
	
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public @ResponseBody ApiDto getApi(){
 		RcUser apiDto = new RcUser();
 		return objectMapper.map(apiDto, ApiDto.class);
	}
	
	@RequestMapping(value="/api/app",method=RequestMethod.GET)
	public @ResponseBody AppDto getApp(){
		RcUser appDto = new RcUser();
		return objectMapper.map(appDto, AppDto.class);
	}

}
