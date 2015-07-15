package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caocao.core.model.Button;
import com.caocao.core.model.UserToButton;
import com.caocao.core.service.ButtonService;

@Controller
@RequestMapping("button")
public class ButtonController {
	private static final Logger logger = LoggerFactory
			.getLogger(ButtonController.class);
	
	@Resource
	private ButtonService buttonService;
	
	@RequestMapping("buttonlist")
	public String QueryButtonList(@ModelAttribute UserToButton userToButton, HttpSession session) {
		List<Button> buttonList = buttonService.QueryButtonList(userToButton);
		session.setAttribute("buttonList", buttonList);
		return "../abc";
	}
}
