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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.Admin;
import com.caocao.core.service.UserManageService;
import com.caocao.web.constant.ActiveCst;
import com.caocao.web.constant.DateAndStr;

@Controller
@RequestMapping("usermanage")
public class UserManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserManageController.class);
	
	@Resource
	private UserManageService userManageService;
	
	//0：必填写项不能为空！；1:手机号已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute Admin admin) {
		int success = 100;
//		List<String> errors = check(admin);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		admin.setIsactive(0);
		admin.setCreatetime(new Date());
		Admin modelDO = userManageService.QueryOne(admin);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = userManageService.insert(admin);
			if(result > 0) {
				success = 3;
			} else {
				success = 2;
			}
			return success;
		}
	}
	
	//0：必填写项不能为空！；1:后台数据已发生变化，请重新提取数据；2：数据修改失败；3：数据修改成功；4:系统异常请联系管理员；
	@RequestMapping(value = "/update")
	@ResponseBody
	public int update(@ModelAttribute Admin admin) {
		int success = 100;
//		List<String> errors = check(admin);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		admin.setUpdatetime(new Date());
		Admin modelDO = userManageService.QueryById(admin);
		if(!(modelDO == null)) {
				int result = userManageService.update(admin);
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
	public Map<String, Object> QueryPageList(@ModelAttribute Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Admin> list = userManageService.QueryPageList(admin);
		for(int i=0; i<list.size(); i++) {
			if(null != list.get(i).getIsactive()) {
				if(0 == list.get(i).getIsactive()) {
					list.get(i).setIsactiveStr(ActiveCst.IsActive.NO);
				} else if(1 == list.get(i).getIsactive()) {
					list.get(i).setIsactiveStr(ActiveCst.IsActive.YES);
				}
			}
			
			if(null != list.get(i).getLogintime()) {
				list.get(i).setLoginTimeStr(DateAndStr.DateToStrHour(list.get(i).getLogintime()));
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	//查询单个用户信息
	@RequestMapping(value = "/queryone")
	@ResponseBody
	public Admin QueryOne(@ModelAttribute Admin admin) {
		Admin modelDO = userManageService.QueryOne(admin);
		return modelDO;
	}
	
	private List<String> check(Admin admin) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(admin.getUsername())) {
			errors.add("用户名不能为空，请填写用户名！");
		}
		if(StringUtils.isEmpty(admin.getPhone())) {
			errors.add("手机号码不能为空，请填写手机号！");
		}
		if(StringUtils.isEmpty(admin.getPost())) {
			errors.add("岗位不能为空，请填写岗位名称");
		}
		if(StringUtils.isEmpty(admin.getCompanyName())) {
			errors.add("公司名称不能为空，请填写公司名称！");
		}
		return errors;
	}
}
