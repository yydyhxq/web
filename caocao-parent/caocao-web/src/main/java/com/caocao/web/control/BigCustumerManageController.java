package com.caocao.web.control;

import java.util.ArrayList;
import java.util.Date;
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

import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerBase;
import com.caocao.core.model.BigCustumerCost;
import com.caocao.core.model.Custumer;
import com.caocao.core.service.BigCustumerManageService;
import com.caocao.web.constant.DateAndStr;
import com.caocao.web.constant.SexCst;

@Controller
@RequestMapping("bigcustumermanage")
public class BigCustumerManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(BigCustumerManageController.class);
	
	@Resource
	private BigCustumerManageService bigCustumerManageService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute Custumer custumer) {
		int success = 100;
//		List<String> errors = check(custumer);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		custumer.setType(2);
		custumer.setCreatetime(new Date());
		Custumer modelDO = bigCustumerManageService.QueryOne(custumer);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = bigCustumerManageService.insert(custumer);
			if(result > 0) {
				success = 3;
			} else {
				success = 2;
			}
			return success;
		}
	}
	
	//大客户修改
	@RequestMapping(value = "/update")
	@ResponseBody
	public int update(@ModelAttribute Custumer custumer) {
		int success = 100;
//		List<String> errors = check(custumer);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		custumer.setType(2);
		custumer.setUpdatetime(new Date());
		Custumer modelDO = bigCustumerManageService.QueryById(custumer);
		if(!(modelDO == null)) {
				int result = bigCustumerManageService.update(custumer);
				if(result > 0) {
					success = 3;
				} else {
					success = 2;
				}
				return success;
		} else {
			success = 4;
			return success;
		}
	}
	
	//查询批量用户信息
	@RequestMapping(value = "/query")
	@ResponseBody
	public Map<String, Object> QueryPageList(@ModelAttribute Custumer custumer) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Custumer> list = bigCustumerManageService.QueryPageList(custumer);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	//查询单个用户信息
	@RequestMapping(value = "/queryone")
	@ResponseBody
	public Custumer QueryOne(@ModelAttribute Custumer custumer) {
		Custumer modelDO = bigCustumerManageService.QueryOne(custumer);
		return modelDO;
	}
	
	@RequestMapping(value = "/queryaccount")
	@ResponseBody
	public Map<String, Object> QueryBigCustumerAccount(@ModelAttribute BigCustumerAccount bigCustumerAccount) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigCustumerAccount> list = bigCustumerManageService.QueryBigCustumerAccount(bigCustumerAccount);
		if(list.size()>0) {
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getSex()) {
					if(1 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.MAN);
					} else if (2 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.WOMAN);
					}
				}
			  }
			}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/querycost")
	@ResponseBody
	public Map<String, Object> QueryBigCustumerCost(@ModelAttribute BigCustumerCost bigCustumerCost) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigCustumerCost> list = bigCustumerManageService.QueryBigCustumerCost(bigCustumerCost);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/querybase")
	@ResponseBody
	public Map<String, Object> QueryBigCustumerBase(@ModelAttribute BigCustumerBase bigCustumerBase) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigCustumerBase> list = bigCustumerManageService.QueryBigCustumerBase(bigCustumerBase);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getRegisterTime() != null) {
				list.get(i).setRegisterTimeStr(DateAndStr.DateToStr(list.get(i).getRegisterTime()));
			}
		for(int j=0; j<list.size(); j++) {
			if(null != list.get(j).getSex()) {
				if(0 == list.get(j).getSex()) {
					list.get(j).setSexStr(SexCst.Sex.MAN);
				} else if (1 == list.get(j).getSex()) {
					list.get(j).setSexStr(SexCst.Sex.WOMAN);
				}
			}
		}
	}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	private List<String> check(Custumer custumer) {
		List<String> errors = new ArrayList<String>();
		return errors;
	}
}
