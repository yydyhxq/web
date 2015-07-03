package com.caocao.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.AdminMapper;
import com.caocao.core.model.Admin;
import com.caocao.core.model.AdminExample;
import com.caocao.core.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private AdminMapper adminMapper;
	
	@Override
	public Admin QueryOne(Admin admin) {
		Admin modelDO = null;
		AdminExample example=new AdminExample();
		example.createCriteria().andPhoneEqualTo(admin.getPhone());
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0) {
			modelDO = list.get(0);
		}
		return modelDO;
	}
	
	public int updateLoginTime(int id) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setLogintime(new Date());
		int result = adminMapper.updateByPrimaryKeySelective(admin);
		return result;
	}
}
