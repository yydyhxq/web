package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.LabourMapper;
import com.caocao.core.model.Labour;
import com.caocao.core.service.LabourManageService;

@Service("labourManageService")
public class LabourManageServiceImpl implements LabourManageService {
	@Resource
	private LabourMapper labourMapper;
	
	public Labour QueryOne(Labour labour) {
		 Labour modelDO = labourMapper.QueryOne(labour);
		 return modelDO;
	}
	
	public Labour QueryById(Labour labour) {
		 Labour modelDO = labourMapper.QueryById(labour);
		 return modelDO;
	}
	
	public List<Labour> QueryPageList(Labour labour){
		List<Labour> list = labourMapper.QueryPageList(labour);
		return list;
	}
	
	public int insert(Labour labour) {
		int result = labourMapper.insert(labour);
		return result;
	}
	
	public int update(Labour labour) {
		int result = labourMapper.updateByPrimaryKeySelective(labour);
		return result;
	}
}
