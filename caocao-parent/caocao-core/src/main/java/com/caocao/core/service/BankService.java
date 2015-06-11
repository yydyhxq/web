package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Bank;

public interface BankService {

    
    int insert(Bank record);


    int insertSelective(Bank record);

    List<Bank> acquireBankByUserId(int userId);
}