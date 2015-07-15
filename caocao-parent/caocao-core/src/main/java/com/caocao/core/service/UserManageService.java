package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Admin;

public interface UserManageService {
	
	Admin QueryOne(Admin admin);
	
	Admin QueryById(Admin admin);
	
	List<Admin> QueryPageList(Admin admin);
	
	int insert(Admin admin);
	
	int update(Admin admin);
	
	int updateStatus(Admin admin);
}
