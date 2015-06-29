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
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;
import com.caocao.core.service.ComCustumerManageService;
import com.caocao.web.constant.SexCst;

@Controller
@RequestMapping("comcustumer")
public class ComCustumerManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(ComCustumerManageController.class);
	
	@Resource
	private ComCustumerManageService comCustumerManageService;
	
	@RequestMapping(value = "/combase")
	@ResponseBody
	public Map<String, Object> QueryComCustumer(@ModelAttribute ComCustumer comCustumer) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumer> list = comCustumerManageService.SelectComCustumer(comCustumer);
		if(list.size()>0) {
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getSex()) {
					if(0 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.MAN);
					} else if (1 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.WOMAN);
					}
				}
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/comaccount")
	@ResponseBody
	public Map<String, Object> QueryComCustumerAccount(@ModelAttribute ComCustumerAccount comCustumerAccount) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumerAccount> list = comCustumerManageService.SelectComCustumerAccount(comCustumerAccount);
		if(list.size()>1) {
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getSex()) {
					if(0 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.MAN);
					} else if (1 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.WOMAN);
					}
				}
			  }
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/comcost")
	@ResponseBody
	public Map<String, Object> QueryComCustumerCost(@ModelAttribute ComCustumerCost comCustumerCost) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ComCustumerCost> list = comCustumerManageService.SelectComCustumerCost(comCustumerCost);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
}
