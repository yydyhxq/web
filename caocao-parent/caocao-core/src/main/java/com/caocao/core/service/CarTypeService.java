package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.CarType;

public interface CarTypeService {

	CarType QueryOne(CarType carType);
	
	CarType QueryById(CarType carType);
	
	List<CarType> QueryPageList(CarType carType);
	
	int insert(CarType carType);
	
	int update(CarType carType);
}
