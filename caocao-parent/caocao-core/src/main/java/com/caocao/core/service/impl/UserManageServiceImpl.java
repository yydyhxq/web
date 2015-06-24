package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.AdminMapper;
import com.caocao.core.model.Admin;
import com.caocao.core.service.UserManageService;

@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {
	@Resource
	private AdminMapper adminMapper;
	
	public Admin QueryOne(Admin admin) {
		Admin modelDO = adminMapper.QueryOne(admin);
		return modelDO;
	}
	
	public Admin QueryById(Admin admin) {
		Admin modelDO = adminMapper.QueryById(admin);
		return modelDO;
	}
	
	public List<Admin> QueryPageList(Admin admin) {
		List<Admin> list = adminMapper.QueryPageList(admin);
		return list;
	}
	
	public int insert(Admin admin) {
		int result = adminMapper.insert(admin);
		return result;
	}
	
	public int update(Admin admin) {
		int result = adminMapper.updateByPrimaryKey(admin);
		return result;
	}

}
