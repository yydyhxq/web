package com.caocao.core.service;

import com.caocao.core.model.Custumer;


public interface CustumerService {
   public Custumer verifyCustumer(int mobile);
   public int registerUser(Custumer custumer);
   public Custumer acquireById(int userid);
   public int updateCustumer(Custumer custumer);
}