package com.caocao.web.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caocao.core.model.Driver;
import com.caocao.core.service.DriverManageService;

@Controller
@RequestMapping("drivermanage")
public class DriverManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(DriverManageController.class);
	
	@Resource
	private DriverManageService driverManageService;
	
	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public String add(@RequestParam Driver driver, ModelMap map) {
		List<String> errors = check(driver);
		if(errors.size()>0){
			map.put("errors", errors);
			return ".jsp";
		}
		driver.setCreatetime(new Date());
		Driver modelDO = driverManageService.QueryOne(driver);
		if (!StringUtils.isEmpty(modelDO.toString())) {
			map.put("result", "司机已存在！");
			return ".jsp";
		} else {
			int result = driverManageService.insert(driver);
			if(result > 0) {
				map.put("result", "数据新增成功！");
			} else {
				map.put("result", "数据新增失败！");
			}
			return ".jsp";
		}
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public String update(@RequestParam Driver driver, ModelMap map) {
		List<String> errors = check(driver);
		if(errors.size()>0){
			map.put("errors", errors);
			return ".jsp";
		}
		driver.setUpdatetime(new Date());
		Driver modelDO = driverManageService.QueryOne(driver);
		if(!StringUtils.isEmpty(modelDO.toString())) {
		if((driver.getVersion()).equals(modelDO.getVersion())) {
			int result = driverManageService.update(driver);
			if(result > 0) {
				map.put("result", "数据修改成功！");
			} else {
				map.put("result", "数据修改失败！");
			}
			return ".jsp";
		} else {
			map.put("result", "版本号已发生变化，不允许更改！");
			return ".jsp";
		}
	} else {
		map.put("result", "数据库中无此条记录!");
		return ".jsp";
	}
	}
	
	@RequestMapping(value = "/query", method = {RequestMethod.POST})
	public void QueryDrivers(@RequestParam Driver driver) {
		List<Driver> list = driverManageService.QueryPageList(driver);
	}
	
	private List<String> check(Driver driver) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(driver.getName())) {
			errors.add("司机姓名不能为空，请填写司机姓名！");
		}
			return errors;
	}
}
