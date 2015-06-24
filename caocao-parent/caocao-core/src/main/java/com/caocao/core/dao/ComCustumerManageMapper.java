package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;

public interface ComCustumerManageMapper {

	List<ComCustumerAccount> SelectComCustumerAccount(ComCustumerAccount record);
	
	List<ComCustumerCost> SelectComCustumerCost(ComCustumerCost comCustumerCost);
	
	List<ComCustumer> SelectComCustumer(ComCustumer comCustumer);
}
