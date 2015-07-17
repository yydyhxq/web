package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.Privilege;
import com.caocao.core.model.UserToMenu;

public interface PrivilegeMapper {

	List<Privilege> QueryPrivilegeList(Privilege privilege);
	
	int deleteByUserId(UserToMenu userToMenu);
}
