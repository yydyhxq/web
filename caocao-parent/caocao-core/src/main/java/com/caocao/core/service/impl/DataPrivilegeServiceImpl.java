package com.caocao.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.DataPrivilegeMapper;
import com.caocao.core.model.DataPrivilege;
import com.caocao.core.service.DataPrivilegeService;

@Service("dataPrivilegeService")
public class DataPrivilegeServiceImpl implements DataPrivilegeService {

	@Resource
	private DataPrivilegeMapper dataPrivilegeMapper;
	
	public DataPrivilege QueryDataPrivilege(DataPrivilege dataPrivilege){
		 DataPrivilege modelDO = dataPrivilegeMapper.QueryDataPrivilege(dataPrivilege);
		 return modelDO;
	}
}
