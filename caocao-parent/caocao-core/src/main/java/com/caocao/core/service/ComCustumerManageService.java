package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;

public interface ComCustumerManageService {

	List<ComCustumer> SelectComCustumer(ComCustumer comCustumer);
	
	List<ComCustumerAccount> SelectComCustumerAccount(ComCustumerAccount comCustumerAccount);
	
	List<ComCustumerCost> SelectComCustumerCost(ComCustumerCost comCustumerCost);
}
