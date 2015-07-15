package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.LeaseMapper;
import com.caocao.core.model.Lease;
import com.caocao.core.service.LeaseManageService;

@Service("leaseManageService")
public class LeaseManageServiceImpl implements LeaseManageService {
	@Resource
	private LeaseMapper leaseMapper;
	
	public Lease QueryOne(Lease lease) {
		 Lease modelDO = leaseMapper.QueryOne(lease);
		 return modelDO;
	}
	
	public Lease QueryById(Lease lease) {
		 Lease modelDO = leaseMapper.QueryById(lease);
		 return modelDO;
	}
	
	public List<Lease> QueryPageList(Lease lease) {
		List<Lease> list = leaseMapper.QueryPageList(lease);
		return list;
	}
	
	public int insert(Lease lease) {
		int result = leaseMapper.insert(lease);
		return result;
	}
	
	public int update(Lease lease) {
		int result = leaseMapper.updateByPrimaryKeySelective(lease);
		return result;
	}
}
