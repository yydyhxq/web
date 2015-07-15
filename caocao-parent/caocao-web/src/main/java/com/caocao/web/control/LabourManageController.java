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

import com.caocao.core.model.Labour;
import com.caocao.core.service.LabourManageService;
import com.caocao.web.constant.DateAndStr;

@Controller
@RequestMapping("labourmanage")
public class LabourManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(LabourManageController.class);
	@Resource
	private LabourManageService labourManageService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute Labour labour) {
		int success = 100;
//		List<String> errors = check(labour);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		labour.setCreatetime(new Date());
		Labour modelDO = labourManageService.QueryOne(labour);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = labourManageService.insert(labour);
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
	public int update(@ModelAttribute Labour labour) {
		int success = 100;
//		List<String> errors = check(labour);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		labour.setUpdatetime(new Date());
		Labour modelDO = labourManageService.QueryById(labour);
		if(!(modelDO == null)) {
				int result = labourManageService.update(labour);
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
		public Map<String, Object> QueryPageList(@ModelAttribute Labour labour) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Labour> list = labourManageService.QueryPageList(labour);
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getSignDate()) {
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
		public Labour QueryOne(@ModelAttribute Labour labour) {
			Labour modelDO = labourManageService.QueryOne(labour);
			return modelDO;
		}
	
	private List<String> check(Labour labour) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(labour.getName())) {
			errors.add("劳务公司名称不能为空，请填写劳务公司名称！");
		}
		if(StringUtils.isEmpty(labour.getCityCode())) {
			errors.add("所在城市名称不能为空，请填写所在城市名称！");
		}
		if(StringUtils.isEmpty(labour.getCompanyCode())) {
			errors.add("企业代码不能为空，请填写企业代码！");
		}
		if(StringUtils.isEmpty(labour.getMasterName())) {
			errors.add("法人代表不能为空，请填写法人代表！");
		}
		if(StringUtils.isEmpty(labour.getMasterNumber())) {
			errors.add("法人身份证号不能为空，请填写法人身份证号！");
		}
		if(StringUtils.isEmpty(labour.getContactPhone())) {
			errors.add("联系电话不能为空，请填写联系电话！");
		}
		if(StringUtils.isEmpty(labour.getCompanyAddress())) {
			errors.add("公司地址不能为空，请填写公司地址！");
		}
		return errors;
	}
}
