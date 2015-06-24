package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerCost;

public interface BigCustumerManageMapper {

	List<BigCustumerAccount> SelectAll();
	
	List<BigCustumerCost> SelectBigCustumerCost(BigCustumerCost record);
}
