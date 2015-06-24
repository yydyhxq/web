package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caocao.core.model.Admin;
import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;
import com.caocao.core.service.ComCustumerManageService;
import com.caocao.core.service.UserManageService;

@Controller
@RequestMapping("comcustumer")
public class ComCustumerManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(ComCustumerManageController.class);
	
	@Resource
	private ComCustumerManageService comCustumerManageService;
	
	@RequestMapping(value = "/comCustumer", method = { RequestMethod.GET})
	public String QueryComCustumer(ComCustumer comCustumer, ModelMap model) {
		List<ComCustumer> list = comCustumerManageService.SelectComCustumer(comCustumer);
		model.put("list", list);
		return ".jsp";
	}
	
	@RequestMapping(value = "/comCustumerAccount", method = { RequestMethod.GET})
	public String QueryComCustumerAccount(ComCustumerAccount comCustumerAccount, ModelMap model) {
		List<ComCustumerAccount> list = comCustumerManageService.SelectComCustumerAccount(comCustumerAccount);
		model.put("list", list);
		return ".jsp";
	}
	
	@RequestMapping(value = "/comCustumerCost", method = { RequestMethod.GET})
	public String QueryComCustumerCost(ComCustumerCost comCustumerCost, ModelMap model) {
		List<ComCustumerCost> list = comCustumerManageService.SelectComCustumerCost(comCustumerCost);
		model.put("list", list);
		return ".jsp";
	}
}
