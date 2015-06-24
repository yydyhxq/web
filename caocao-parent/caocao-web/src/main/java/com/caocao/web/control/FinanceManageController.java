package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caocao.core.model.FinanceManage;
import com.caocao.core.service.FinanceManageService;

@Controller
@RequestMapping("financemanage")
public class FinanceManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(FinanceManageController.class);
	
	@Resource
	private FinanceManageService financeManageService;
	
	@RequestMapping(value = "/queryCustumer", method = {RequestMethod.POST})
	public String QueryBigCustomerAccountStat(@RequestParam FinanceManage financeManage, ModelMap model) {
		List<FinanceManage> list = financeManageService.SelectBigCustomerAccountStat(financeManage);
		model.put("list", list);
		return ".jsp";
	}
	
	@RequestMapping(value = "/queryBusiness", method = {RequestMethod.POST})
	public String QueryBusinesTotalIncomeStat(@RequestParam FinanceManage financeManage, ModelMap model) {
		List<FinanceManage> list = financeManageService.SelectBusinesTotalIncomeStat(financeManage);
		model.put("list", list);
		return ".jsp";
	}
	
	@RequestMapping(value = "/queryPlat", method = {RequestMethod.POST})
	public String QueryPlatRewardStat(@RequestParam FinanceManage financeManage, ModelMap model) {
		List<FinanceManage> list = financeManageService.SelectPlatRewardStat(financeManage);
		model.put("list", list);
		return ".jsp";
	}
	
	@RequestMapping(value = "/queryDriver", method = {RequestMethod.POST})
	public String QueryDriverIncome(@RequestParam FinanceManage financeManage, ModelMap model) {
		List<FinanceManage> list = financeManageService.SelectDriverIncome(financeManage);
		model.put("list", list);
		return ".jsp";
	}
}
