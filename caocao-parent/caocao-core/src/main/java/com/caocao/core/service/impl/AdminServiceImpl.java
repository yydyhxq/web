package com.caocao.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.AdminMapper;
import com.caocao.core.model.Admin;
import com.caocao.core.model.AdminExample;
import com.caocao.core.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminMapper adminMapper;
	
	public int countByExample(AdminExample example) {
		// TODO Auto-generated method stub		
		return adminMapper.countByExample(example);
	
	}
	public Admin selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub		
		return adminMapper.selectByPrimaryKey(id);
	}

}
