package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.FinanceManage;

public interface FinanceManageService {

	List<FinanceManage> SelectBigCustomerAccountStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectBusinesTotalIncomeStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectPlatRewardStat(FinanceManage financeManage);
	
	List<FinanceManage> SelectDriverIncome(FinanceManage financeManage);
}
