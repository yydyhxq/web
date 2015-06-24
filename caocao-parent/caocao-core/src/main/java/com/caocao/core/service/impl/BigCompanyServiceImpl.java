package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.VipCompanyMapper;
import com.caocao.core.model.VipCompany;
import com.caocao.core.service.BigCompanyService;

@Service("bigCompanyService")
public class BigCompanyServiceImpl implements BigCompanyService {
	@Resource
	private VipCompanyMapper vipCompanyMapper;
	
	public VipCompany QueryOne(VipCompany vipCompany) {
		VipCompany modelDO = vipCompanyMapper.QueryOne(vipCompany);
		 return modelDO;
	}
	
	public VipCompany QueryById(VipCompany vipCompany) {
		VipCompany modelDO = vipCompanyMapper.QueryById(vipCompany);
		 return modelDO;
	}
	
	public List<VipCompany> QueryPageList(VipCompany vipCompany){
		List<VipCompany> list = vipCompanyMapper.QueryPageList(vipCompany);
		return list;
	}
	
	public int insert(VipCompany vipCompany) {
		int result = vipCompanyMapper.insert(vipCompany);
		return result;
	}
	
	public int update(VipCompany vipCompany) {
		int result = vipCompanyMapper.updateByPrimaryKey(vipCompany);
		return result;
	}

}
