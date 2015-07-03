package com.caocao.core.service;

import java.io.InputStream;
import java.util.List;

import com.caocao.core.model.Driver;

public interface DriverManageService {

	Driver QueryOne(Driver driver);
	
	Driver QueryById(Driver driver);
	
	List<Driver> QueryPageList(Driver driver);
	
	List<Driver> QueryQualifiedList(Driver driver);
	
	int insert(Driver driver);
	
	int update(Driver driver);
	
	String DriversImport(InputStream is, String type);
}
