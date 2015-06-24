package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.DriverMapper;
import com.caocao.core.model.Driver;
import com.caocao.core.model.DriverExample;
import com.caocao.core.service.DriverManageService;

@Service("driverManageService")
public class DriverManageServiceImpl implements DriverManageService {
	@Resource
	private DriverMapper driverMapper;
	
	public Driver QueryOne(Driver driver) {
		Driver modelDO = null;
		List<Driver> list = driverMapper.QueryPageList(driver);
		if(list.size()>0) {
			modelDO = list.get(0);
		}
		return modelDO;
	}
	
	public List<Driver> QueryPageList(Driver driver) {
		List<Driver> list = driverMapper.QueryPageList(driver);
		return list;
	}
	
	public int insert(Driver driver) {
		int result = driverMapper.insert(driver);
		return result;
	}
	
	public int update(Driver driver) {
		int result = driverMapper.updateByPrimaryKey(driver);
		return result;
	}
}
