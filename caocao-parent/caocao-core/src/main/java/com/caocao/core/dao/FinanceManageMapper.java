package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.FinanceManage;

public interface FinanceManageMapper {

	List<FinanceManage> SelectBigCustomerAccountStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectBusinesTotalIncomeStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectPlatRewardStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectDriverIncome(FinanceManage financeManage);
}
