package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerCost;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.Labour;

public interface BigCustumerManageService {

	Custumer QueryOne(Custumer custumer);
	
	Custumer QueryById(Custumer custumer);
	
	List<Custumer> QueryPageList(Custumer custumer);
	
	List<BigCustumerAccount> QueryBigCustumersDetail();
	
	List<BigCustumerCost> QueryBigCustumerCost(BigCustumerCost bigCustumerCost);
	
	int insert(Custumer custumer);
	
	int update(Custumer custumer);
}
