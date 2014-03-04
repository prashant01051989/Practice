package com.ironmountain.recordcenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironmountain.domain.orm.rc2db.i18n.Message;
import com.ironmountain.dto.i18n.MessageDto;
import com.ironmountain.dto.i18n.MessagesWrapper;
import com.ironmountain.dto.i18n.MessagesWrapperDto;
import com.ironmountain.recordcenter.common.RecordCenterUriFormats;
import com.ironmountain.recordcenter.service.LocaleService;

@Controller
public class LocaleController {

	public static final String POST_ENCODING = "UTF-8";
	
	private static final Logger LOG = org.slf4j.LoggerFactory
			.getLogger(LocaleController.class);

	/*@Autowired
	private JettisonUtils jettisonUtils;
	*/
	@Autowired
	private com.ironmountain.common.uriframework.IronMountainMapper objectMapper;
	
	
	@Autowired
	private LocaleService localeService;
	
	@GET
	@RequestMapping(value = RecordCenterUriFormats.LOCALE_ROOT+"/{locale}", method = RequestMethod.GET)
	public @ResponseBody MessagesWrapperDto getBundle(@PathVariable("locale") String locale, HttpServletRequest request) {
		MessagesWrapperDto messagesResponse;
		List<Message> messageList = localeService.getUIMessagesByLocale(locale);	
		MessagesWrapper messagesWrapper = new MessagesWrapper();
		messagesWrapper.setMessages(messageList);
		
		MessagesWrapperDto messagesWrapperDto = createMessagesWrapperDto(messagesWrapper);
		try {
			final MessagesWrapperDto messages = objectMapper.map(messagesWrapperDto, MessagesWrapperDto.class);
			messagesResponse=messages;
		} catch (Exception sie) {
			//TODO need to validate this exception, this looks like it is generated as there is no connection made to the core services
			LOG.error("Proxy generated exception.", sie);
			throw new RuntimeException(sie);
		}
 		return messagesResponse;
	}
	
	private MessagesWrapperDto createMessagesWrapperDto(final MessagesWrapper messagesWrapper) {
		MessagesWrapperDto messagesWrapperDto = new MessagesWrapperDto();
		List<MessageDto> newMessageDtoList = new ArrayList<MessageDto>();
		//TODO we can use Dozer mapper instead of manual copy
		for (Message message : messagesWrapper.getMessages()) {
			MessageDto newMessageDto = new MessageDto();
			newMessageDto.setKey(message.getMessagePK().getMessageKey());
			newMessageDto.setValue(message.getMessage());
			newMessageDtoList.add(newMessageDto);
		}

		messagesWrapperDto.setCount(newMessageDtoList.size());
		messagesWrapperDto.setTotal(newMessageDtoList.size());
		messagesWrapperDto.setMessages(newMessageDtoList);

		return messagesWrapperDto;
	}
}
