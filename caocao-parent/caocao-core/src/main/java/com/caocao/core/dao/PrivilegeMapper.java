package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.Privilege;

public interface PrivilegeMapper {

	List<Privilege> QueryPrivilegeList(Privilege privilege);
}
