package com.caocao.web.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.FinanceManage;
import com.caocao.core.service.FinanceManageService;

@Controller
@RequestMapping("financemanage")
public class FinanceManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(FinanceManageController.class);
	
	@Resource
	private FinanceManageService financeManageService;
	
	@RequestMapping(value = "/querycustumer")
	@ResponseBody
	public Map<String, Object> QueryBigCustomerAccountStat(@ModelAttribute FinanceManage financeManage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FinanceManage> list = financeManageService.SelectBigCustomerAccountStat(financeManage);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/querybusiness")
	@ResponseBody
	public Map<String, Object> QueryBusinesTotalIncomeStat(@ModelAttribute FinanceManage financeManage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FinanceManage> list = financeManageService.SelectBusinesTotalIncomeStat(financeManage);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/queryplat")
	@ResponseBody
	public Map<String, Object> QueryPlatRewardStat(@ModelAttribute FinanceManage financeManage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FinanceManage> list = financeManageService.SelectPlatRewardStat(financeManage);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/querydriver")
	@ResponseBody
	public Map<String, Object> QueryDriverIncome(@ModelAttribute FinanceManage financeManage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FinanceManage> list = financeManageService.SelectDriverIncome(financeManage);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
}
