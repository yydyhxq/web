package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.CustumerMapper;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.CustumerExample;
import com.caocao.core.service.CustumerService;
@Service("custumerService")
public class CustumerServiceImpl implements CustumerService {
	@Resource
	private CustumerMapper custumerMapper;

	@Override
	public Custumer verifyCustumer(int mobile) {
		// TODO Auto-generated method stub
		CustumerExample example=new CustumerExample();
		example.createCriteria().andPhoneEqualTo(mobile);
		List<Custumer> lst=custumerMapper.selectByExample(example);
		if(null!=lst&&lst.size()>0)
		{
			return lst.get(0);
		}
		return null;
	}

	@Override
	public int registerUser(Custumer custumer) {
		// TODO Auto-generated method stub
		return custumerMapper.insertSelective(custumer);
		
	}

	@Override
	public Custumer acquireById(int userid) {
		// TODO Auto-generated method stub
		return custumerMapper.selectByPrimaryKey(userid);
	}

	@Override
	public int updateCustumer(Custumer custumer) {
		// TODO Auto-generated method stub
		return custumerMapper.updateByPrimaryKeySelective(custumer);
	}
	
}
