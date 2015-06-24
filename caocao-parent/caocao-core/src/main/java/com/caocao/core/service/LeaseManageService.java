package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Lease;

public interface LeaseManageService {

	Lease QueryOne(Lease lease);
	
	Lease QueryById(Lease lease);
	
	List<Lease> QueryPageList(Lease lease);
	
	int insert(Lease lease);
	
	int update(Lease lease);
}
