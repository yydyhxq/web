package com.caocao.core.service;

import com.caocao.core.model.Admin;
import com.caocao.core.model.AdminExample;



public interface AdminService {	 
	  int countByExample(AdminExample example);
	  Admin selectByPrimaryKey(int id);
}
