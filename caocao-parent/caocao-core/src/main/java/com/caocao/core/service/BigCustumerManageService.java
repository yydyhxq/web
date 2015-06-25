package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerBase;
import com.caocao.core.model.BigCustumerCost;
import com.caocao.core.model.Custumer;

public interface BigCustumerManageService {

	Custumer QueryOne(Custumer custumer);
	
	Custumer QueryById(Custumer custumer);
	
	List<Custumer> QueryPageList(Custumer custumer);
	
	List<BigCustumerAccount> QueryBigCustumerAccount(BigCustumerAccount bigCustumerAccount);
	
	List<BigCustumerCost> QueryBigCustumerCost(BigCustumerCost bigCustumerCost);
	
	List<BigCustumerBase> QueryBigCustumerBase(BigCustumerBase bigCustumerBase);
	
	int insert(Custumer custumer);
	
	int update(Custumer custumer);
}
