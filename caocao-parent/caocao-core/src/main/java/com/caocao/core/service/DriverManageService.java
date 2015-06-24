package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Driver;

public interface DriverManageService {

	Driver QueryOne(Driver driver);
	
	List<Driver> QueryPageList(Driver driver);
	
	int insert(Driver driver);
	
	int update(Driver driver);
}
