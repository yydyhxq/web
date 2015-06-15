package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.BankMapper;
import com.caocao.core.model.Bank;
import com.caocao.core.model.BankExample;
import com.caocao.core.service.BankService;
@Service("bankService")
public class BankServiceImpl implements BankService {
@Resource
private BankMapper bankMapper;
	@Override
	public int insert(Bank record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Bank record) {
		// TODO Auto-generated method stub
		return bankMapper.insertSelective(record);
	}

	@Override
	public List<Bank> acquireBankByUserId(int userId) {
		// TODO Auto-generated method stub
		BankExample example=new BankExample();
		//此处需修改成INT类型
		example.createCriteria().andAgentIdEqualTo(String.valueOf(userId));
		return bankMapper.selectByExample(example);
	}

}
