package com.caocao.web.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.CarType;
import com.caocao.core.service.CarTypeService;

@Controller
@RequestMapping("cartype")
public class CarTypeController {
	private static final Logger logger = LoggerFactory
			.getLogger(CarTypeController.class);
	
	@Resource
	private CarTypeService carTypeService;
	
	//0：必填写项不能为空！；1:该公司已存在！；2:数据新增失败；3：数据新增成功！；
	@RequestMapping(value = "/add")
	@ResponseBody
	public int add(@ModelAttribute CarType carType) {
		int success = 100;
		List<String> errors = check(carType);
		if(errors.size()>0){
			success = 0;
			return success;
		}
		carType.setCreatetime(new Date());
		CarType modelDO = carTypeService.QueryOne(carType);
		if(!(modelDO == null)) {
			success = 1;
			return success;
		} else {
			int result = carTypeService.insert(carType);
			if(result > 0) {
				success = 3;
			} else {
				success = 2;
			}
			return success;
		}
	}
	
	@RequestMapping(value = "/update")
	public int update(@ModelAttribute CarType carType) {
		int success = 100;
		List<String> errors = check(carType);
		if(errors.size()>0){
			success = 0;
			return success;
		}
		carType.setUpdatetime(new Date());
		CarType modelDO = carTypeService.QueryById(carType);
		if(!(modelDO == null)) {
				int result = carTypeService.update(carType);
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
	
//	@RequestMapping(value = "/query", method = {RequestMethod.POST})
//	public String QueryUsers(@RequestParam CarType carType, ModelMap model) {
//		List<CarType> list = carTypeService.QueryCarTypes(carType);
//		model.put("list", list);
//		return ".jsp";
//	}
	
	private List<String> check(CarType carType) {
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(carType.getBrand())) {
			errors.add("品牌不能为空，请填写品牌！");
		}
		if(StringUtils.isEmpty(carType.getMode())) {
			errors.add("车型不能为空， 请填写车型！");
		}
		return errors;
	}
}
