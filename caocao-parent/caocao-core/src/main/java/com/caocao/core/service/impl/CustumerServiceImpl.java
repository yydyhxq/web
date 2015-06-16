package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.CustumerMapper;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.CustumerExample;
import com.caocao.core.model.Journey;
import com.caocao.core.model.MyWallet;
import com.caocao.core.service.CustumerService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
@Service("custumerService")
public class CustumerServiceImpl extends BaseService implements CustumerService {
	@Resource
	private CustumerMapper custumerMapper;

	@Override
	public Custumer verifyCustumer(String mobile) {
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
		CustumerExample example=new CustumerExample();
		example.createCriteria().andPhoneEqualTo(custumer.getPhone());
		if(custumerMapper.countByExample(example)>0)
		{
			return 0;
		}
		else{
		return custumerMapper.insertSelective(custumer);
		}
		
	}

	@Override
	public Custumer acquireById(Integer userid) {
		// TODO Auto-generated method stub
		return custumerMapper.selectByPrimaryKey(userid);
	}

	@Override
	public int updateCustumer(Custumer custumer) {
		// TODO Auto-generated method stub
		return custumerMapper.updateByPrimaryKeySelective(custumer);
	}

	@Override
	public PageList<Journey> acquireJourney(int userId, int pageIndex,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		  return (PageList<Journey>) getPageList(CustumerMapper.class, "aquireJourney",
				   userId, pageIndex, pageSize);
	}

	@Override
	public MyWallet acquireMyWallet(int customerId, int isDefault) {
		// TODO Auto-generated method stub
		return custumerMapper.acquireMyWallet(customerId, isDefault);
	}

	
}
