package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.CarTypeMapper;
import com.caocao.core.model.CarType;
import com.caocao.core.service.CarTypeService;

@Service("carTypeService")
public class CarTypeServiceImpl implements CarTypeService {

	@Resource
	private CarTypeMapper carTypeMapper;
	
	public CarType QueryOne(CarType carType) {
		CarType modelDO = carTypeMapper.QueryOne(carType);
		 return modelDO;
	}
	
	public CarType QueryById(CarType carType) {
		CarType modelDO = carTypeMapper.QueryOne(carType);
		 return modelDO;
	}
	
	public List<CarType> QueryPageList(CarType carType) {
		List<CarType> list = carTypeMapper.QueryPageList(carType);
		 return list;
	}
	
	public int insert(CarType carType) {
		int result = carTypeMapper.insert(carType);
		return result;
	}
	
	public int update(CarType carType) {
		int result = carTypeMapper.updateByPrimaryKey(carType);
		return result;
	}
}
