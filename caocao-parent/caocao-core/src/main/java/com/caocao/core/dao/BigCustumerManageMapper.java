package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerBase;
import com.caocao.core.model.BigCustumerCost;

public interface BigCustumerManageMapper {

	List<BigCustumerAccount> SelectBigCustumerAccount(BigCustumerAccount record);
	
	List<BigCustumerCost> SelectBigCustumerCost(BigCustumerCost record);
	
	List<BigCustumerBase> SelectBigCustumerBase(BigCustumerBase record);
}
