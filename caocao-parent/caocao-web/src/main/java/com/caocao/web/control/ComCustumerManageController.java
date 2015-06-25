package com.caocao.web.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;
import com.caocao.core.service.ComCustumerManageService;

@Controller
@RequestMapping("comcustumer")
public class ComCustumerManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(ComCustumerManageController.class);
	
	@Resource
	private ComCustumerManageService comCustumerManageService;
	
	@RequestMapping(value = "/comcustumer")
	@ResponseBody
	public Map<String, Object> QueryComCustumer(ComCustumer comCustumer) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumer> list = comCustumerManageService.SelectComCustumer(comCustumer);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/comaccount")
	@ResponseBody
	public Map<String, Object> QueryComCustumerAccount(ComCustumerAccount comCustumerAccount) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumerAccount> list = comCustumerManageService.SelectComCustumerAccount(comCustumerAccount);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/comcost")
	@ResponseBody
	public Map<String, Object> QueryComCustumerCost(ComCustumerCost comCustumerCost) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumerCost> list = comCustumerManageService.SelectComCustumerCost(comCustumerCost);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
}
