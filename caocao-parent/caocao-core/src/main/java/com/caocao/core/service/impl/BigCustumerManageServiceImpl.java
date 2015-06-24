package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.BigCustumerManageMapper;
import com.caocao.core.dao.CustumerMapper;
import com.caocao.core.model.BigCustumerAccount;
import com.caocao.core.model.BigCustumerCost;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.CustumerExample;
import com.caocao.core.model.Labour;
import com.caocao.core.service.BigCustumerManageService;

@Service("bigCustumerManageService")
public class BigCustumerManageServiceImpl implements BigCustumerManageService {
	@Resource
	private CustumerMapper custumerMapper;
	@Resource
	private BigCustumerManageMapper bigCustumerManageMapper;
	
	public Custumer QueryOne(Custumer custumer) {
		Custumer modelDO = custumerMapper.QueryOne(custumer);
		 return modelDO;
	}
	
	public Custumer QueryById(Custumer custumer) {
		Custumer modelDO = custumerMapper.QueryById(custumer);
		 return modelDO;
	}
	
	public List<Custumer> QueryPageList(Custumer custumer){
		List<Custumer> list = custumerMapper.QueryPageList(custumer);
		return list;
	}
	
	public List<BigCustumerAccount> QueryBigCustumersDetail() {
		List<BigCustumerAccount> list = bigCustumerManageMapper.SelectAll();
		return list;
	}
	
	public List<BigCustumerCost> QueryBigCustumerCost(BigCustumerCost bigCustumerCost) {
		List<BigCustumerCost> list = bigCustumerManageMapper.SelectBigCustumerCost(bigCustumerCost);
		return list;
	}
	
	public int insert(Custumer custumer) {
		int result = custumerMapper.insert(custumer);
		return result;
	}
	
	public int update(Custumer custumer) {
		int result = custumerMapper.updateByPrimaryKey(custumer);
		return result;
	}
}
