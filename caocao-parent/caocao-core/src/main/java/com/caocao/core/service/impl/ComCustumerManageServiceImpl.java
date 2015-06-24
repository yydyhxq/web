package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.ComCustumerManageMapper;
import com.caocao.core.model.ComCustumer;
import com.caocao.core.model.ComCustumerAccount;
import com.caocao.core.model.ComCustumerCost;
import com.caocao.core.service.ComCustumerManageService;

@Service("comCustumerManageService")
public class ComCustumerManageServiceImpl implements ComCustumerManageService {
	@Resource
	private ComCustumerManageMapper comCustumerManageMapper;
	
	public List<ComCustumer> SelectComCustumer(ComCustumer comCustumer) {
		List<ComCustumer> list = comCustumerManageMapper.SelectComCustumer(comCustumer);
		return list;
	}
	
	public List<ComCustumerAccount> SelectComCustumerAccount(ComCustumerAccount comCustumerAccount) {
		List<ComCustumerAccount> list = comCustumerManageMapper.SelectComCustumerAccount(comCustumerAccount);
		return list;
	}
	
	public List<ComCustumerCost> SelectComCustumerCost(ComCustumerCost comCustumerCost) {
		List<ComCustumerCost> list = comCustumerManageMapper.SelectComCustumerCost(comCustumerCost);
		return list;
	}
}
