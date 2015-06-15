package com.caocao.core.service;

import com.caocao.core.model.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OrderService {
   
    int insert(Order record);

    int insertSelective(Order record);

    int updateOrder(Order record);
   
    Order acquireOrder(int orderId);
    
    PageList<Order> acquireHistoryOrder(int pageIndex, int pageSize,int agentId) throws Exception;
}