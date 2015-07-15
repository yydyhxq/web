package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.PrivilegeMapper;
import com.caocao.core.model.Privilege;
import com.caocao.core.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeMapper privilegeMapper;
	
	public List<Privilege> QueryPrivilegeList(Privilege privilege) {
		List<Privilege> list = privilegeMapper.QueryPrivilegeList(privilege);
		if(list.size()>0) {
			for(int i=0; i<list.size(); i++) {
				if(null != list.get(i).getUserId()) {
					list.get(i).setChecked(true);
				} else {
					list.get(i).setChecked(false);
				}
			}
		}
		return list;
	}
}
