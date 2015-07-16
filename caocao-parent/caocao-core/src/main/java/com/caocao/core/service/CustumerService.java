package com.caocao.core.service;

import com.caocao.core.model.Custumer;
import com.caocao.core.model.Journey;
import com.caocao.core.model.MyWallet;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface CustumerService {
	public Custumer verifyCustumer(String mobile);

	public int registerUser(Custumer custumer);

	public Custumer acquireById(Integer userid);

	public int updateCustumer(Custumer custumer);

	public PageList<Journey> acquireJourney(int userId, int pageIndex, int pageSize)throws Exception;
	
	public MyWallet acquireMyWallet(int customerId,int isDefault);
}