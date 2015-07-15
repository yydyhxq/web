package com.caocao.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caocao.core.model.DataPrivilege;
import com.caocao.core.service.DataPrivilegeService;

@Controller
@RequestMapping("dataprivilege")
public class DataPrivilegeController {
	private static final Logger logger = LoggerFactory
			.getLogger(DataPrivilegeController.class);
	
	@Resource
	private DataPrivilegeService dataPrivilegeService;
	
	@RequestMapping("/hasdata")
	public String QueryDataPrivilege(@ModelAttribute DataPrivilege dataPrivilege, ModelMap map, HttpSession session) {
		DataPrivilege modelDO = dataPrivilegeService.QueryDataPrivilege(dataPrivilege);
		session.setAttribute("dataPrivilege", modelDO);
		return "../abc";
	}
}
