package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Privilege;
import com.caocao.core.model.UserToMenu;

public interface PrivilegeService {

	List<Privilege> QueryPrivilegeList(Privilege privilege);
	
	int deleteByUserId(UserToMenu userToMenu);
}
