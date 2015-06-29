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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.VipCompany;
import com.caocao.core.service.BigCompanyService;
import com.caocao.web.constant.DateAndStr;

@Controller
@RequestMapping("bigcompany")
public class BigCompanyController {
	private static final Logger logger = LoggerFactory
			.getLogger(BigCompanyController.class);
	
	@Resource
	private BigCompanyService bigCompanyService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute VipCompany vipCompany) {
		int success = 100;
//		List<String> errors = check(vipCompany);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		vipCompany.setCreatetime(new Date());
		VipCompany modelDO = bigCompanyService.QueryOne(vipCompany);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = bigCompanyService.insert(vipCompany);
			if(result > 0) {
				success = 3;
			} else {
				success = 2;
			}
			return success;
		}
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public int update(@ModelAttribute VipCompany vipCompany) {
		int success = 100;
//		List<String> errors = check(vipCompany);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		vipCompany.setUpdatetime(new Date());
		VipCompany modelDO = bigCompanyService.QueryById(vipCompany);
		if(!(modelDO == null)) {
				int result = bigCompanyService.update(vipCompany);
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
	public Map<String, Object> QueryPageList(@ModelAttribute VipCompany vipCompany) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<VipCompany> list = bigCompanyService.QueryPageList(vipCompany);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSignDate() != null) {
				list.get(i).setSignDateStr(DateAndStr.DateToStr(list.get(i).getSignDate()));
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	//查询单个用户信息
	@RequestMapping(value = "/queryone")
	@ResponseBody
	public VipCompany QueryOne(@ModelAttribute VipCompany vipCompany) {
		VipCompany modelDO = bigCompanyService.QueryOne(vipCompany);
		return modelDO;
	}
	
		private List<String> check(VipCompany vipCompany) {
			List<String> errors = new ArrayList<String>();
			if(StringUtils.isEmpty(vipCompany.getName())) {
				errors.add("劳务公司名称不能为空，请填写劳务公司名称！");
			}
			if(StringUtils.isEmpty(vipCompany.getCityCode())) {
				errors.add("所在城市名称不能为空，请填写所在城市名称！");
			}
			if(StringUtils.isEmpty(vipCompany.getCompanyCode())) {
				errors.add("企业代码不能为空，请填写企业代码！");
			}
			if(StringUtils.isEmpty(vipCompany.getMasterName())) {
				errors.add("法人代表不能为空，请填写法人代表！");
			}
			if(StringUtils.isEmpty(vipCompany.getMasterNumber())) {
				errors.add("法人身份证号不能为空，请填写法人身份证号！");
			}
			if(StringUtils.isEmpty(vipCompany.getContactPhone())) {
				errors.add("联系电话不能为空，请填写联系电话！");
			}
			if(StringUtils.isEmpty(vipCompany.getCompanyAddress())) {
				errors.add("公司地址不能为空，请填写公司地址！");
			}
			return errors;
		}
}
