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
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.Lease;
import com.caocao.core.service.LeaseManageService;
import com.caocao.web.constant.DateAndStr;

@Controller
@RequestMapping("leasemanage")
public class LeaseManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserManageController.class);
	
	@Resource
	private LeaseManageService leaseManageService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute Lease lease){
		int success = 100;
//		List<String> errors = check(lease);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		lease.setCreatetime(new Date());
		Lease modelDO = leaseManageService.QueryOne(lease);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = leaseManageService.insert(lease);
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
	public int update(@ModelAttribute Lease lease) {
		int success = 100;
//		List<String> errors = check(lease);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		lease.setUpdatetime(new Date());
		Lease modelDO = leaseManageService.QueryById(lease);
		if(!(modelDO == null)) {
				int result = leaseManageService.update(lease);
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
	public Map<String, Object> QueryPageList(@ModelAttribute Lease lease) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Lease> list = leaseManageService.QueryPageList(lease);
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
	public Lease QueryOne(@ModelAttribute Lease lease) {
		Lease modelDO = leaseManageService.QueryOne(lease);
		return modelDO;
	}
	
	private List<String> check(Lease lease) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(lease.getName())) {
			errors.add("劳务公司名称不能为空，请填写劳务公司名称！");
		}
		if(StringUtils.isEmpty(lease.getCityCode())) {
			errors.add("所在城市名称不能为空，请填写所在城市名称！");
		}
		if(StringUtils.isEmpty(lease.getCompanyCode())) {
			errors.add("企业代码不能为空，请填写企业代码！");
		}
		if(StringUtils.isEmpty(lease.getMasterName())) {
			errors.add("法人代表不能为空，请填写法人代表！");
		}
		if(StringUtils.isEmpty(lease.getMasterNumber())) {
			errors.add("法人身份证号不能为空，请填写法人身份证号！");
		}
		if(StringUtils.isEmpty(lease.getContactPhone())) {
			errors.add("联系电话不能为空，请填写联系电话！");
		}
		if(StringUtils.isEmpty(lease.getCompanyAddress())) {
			errors.add("公司地址不能为空，请填写公司地址！");
		}
		return errors;
	}
}
