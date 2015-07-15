package com.caocao.web.control;

import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.caocao.core.model.Driver;
import com.caocao.core.service.DriverManageService;
import com.caocao.web.constant.DateAndStr;
import com.caocao.web.constant.DriverOnlineCst;
import com.caocao.web.constant.OnlineCst;
import com.caocao.web.constant.SexCst;


@Controller
@RequestMapping("drivermanage")
public class DriverManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(DriverManageController.class);
	
	@Resource
	private DriverManageService driverManageService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute Driver driver) {
		int success = 100;
//		List<String> errors = check(driver);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		driver.setIsQualified(1);
		driver.setCreatetime(new Date());
		Driver modelDO = driverManageService.QueryOne(driver);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = driverManageService.insert(driver);
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
	public int update(@ModelAttribute Driver driver) {
		int success = 100;
//		List<String> errors = check(driver);
//		if(errors.size()>0){
//			success = 0;
//			return success;
//		}
		driver.setIsQualified(1);
		driver.setUpdatetime(new Date());
		Driver modelDO = driverManageService.QueryById(driver);
		if(!(modelDO == null)) {
				int result = driverManageService.update(driver);
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
	public Map<String, Object> QueryPageList(@ModelAttribute Driver driver) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Driver> list = driverManageService.QueryPageList(driver);
		for(int i=0; i<list.size(); i++) {
			if(null != list.get(i).getRegisterTime()) {
				list.get(i).setRegisterTimeStr(DateAndStr.DateToStr(list.get(i).getRegisterTime()));
			}
			if(null != list.get(i).getQualifiedDate()) {
				list.get(i).setQualifiedDateStr(DateAndStr.DateToStr(list.get(i).getQualifiedDate()));
			}
			if(null != list.get(i).getSex()) {
				if(1 == list.get(i).getSex()) {
					list.get(i).setSexStr(SexCst.Sex.MAN);
				} else if (2 == list.get(i).getSex()) {
					list.get(i).setSexStr(SexCst.Sex.WOMAN);
				}
			}
			if(null != list.get(i).getOnline()) {
				if(1 == list.get(i).getOnline()) {
					list.get(i).setOnlineStr(DriverOnlineCst.DriverOnline.ONE);
				} else if (2 == list.get(i).getOnline()) {
					list.get(i).setOnlineStr(DriverOnlineCst.DriverOnline.TWO);
				} else if(3 == list.get(i).getOnline()) {
					list.get(i).setOnlineStr(DriverOnlineCst.DriverOnline.THREE);
				}
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	//查询批量用户信息
		@RequestMapping(value = "/queryqualified")
		@ResponseBody
		public Map<String, Object> QueryQualifiedList(@ModelAttribute Driver driver) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Driver> list = driverManageService.QueryQualifiedList(driver);
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getQualifiedDate()) {
					list.get(i).setQualifiedDateStr(DateAndStr.DateToStr(list.get(i).getQualifiedDate()));
				}
				if(null != list.get(i).getQualifiedDate()) {
					list.get(i).setDrivelicenseDateStr(DateAndStr.DateToStr(list.get(i).getDrivelicenseDate()));
				}
				if(null != list.get(i).getSex()) {
					if(1 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.MAN);
					} else if (2 == list.get(i).getSex()) {
						list.get(i).setSexStr(SexCst.Sex.WOMAN);
					}
				}
			}
			map.put("total", list.size());
			map.put("rows", list);
			return map;
		}
	
	//查询单个用户信息
	@RequestMapping(value = "/queryone")
	@ResponseBody
	public Driver QueryOne(@ModelAttribute Driver driver) {
		Driver modelDO = driverManageService.QueryOne(driver);
		return modelDO;
	}
	
	//查询单个用户信息
	@RequestMapping(value = "/queryid")
	@ResponseBody
	public Driver QueryByID(@ModelAttribute Driver driver) {
		Driver modelDO = driverManageService.QueryById(driver);
		return modelDO;
	}
	
	//批量导入初试司机
	@RequestMapping(value = "/driverimport")
	@ResponseBody
	public String DriversImport(MultipartHttpServletRequest execlFile, ModelMap map) {
		MultipartFile uploadfile = execlFile.getFile("execlFile");
		InputStream is;
		String fileName = uploadfile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if("xls".equals(fileSuffix)) {
			try {
				is = uploadfile.getInputStream();
				String errors = driverManageService.DriversImport(is, "xls");
				map.put("errors", errors);
			} catch (IOException e) {
				map.put("errors", e.getMessage());
			}
		}
		return "jsp";
	}
	
	private List<String> check(Driver driver) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(driver.getName())) {
			errors.add("司机姓名不能为空，请填写司机姓名！");
		}
			return errors;
	}
}
