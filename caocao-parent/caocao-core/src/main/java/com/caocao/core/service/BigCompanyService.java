package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.VipCompany;

public interface BigCompanyService {

	VipCompany QueryOne(VipCompany vipCompany);
	
	VipCompany QueryById(VipCompany vipCompany);
	
	List<VipCompany> QueryPageList(VipCompany vipCompany);
	
	int insert(VipCompany vipCompany);
	
	int update(VipCompany vipCompany);
}
