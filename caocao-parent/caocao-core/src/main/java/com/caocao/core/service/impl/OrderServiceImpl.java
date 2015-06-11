package com.caocao.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.OrderMapper;
import com.caocao.core.model.Order;
import com.caocao.core.model.OrderExample;
import com.caocao.core.service.OrderService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
@Service("orderService")
public class OrderServiceImpl extends BaseService implements OrderService {
private static final long serialVersionUID = 6475630222014631023L;
@Resource
private OrderMapper orderMapper;
	@Override
	public int insert(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(record);
	}

	@Override
	public int updateOrder(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Order acquireOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public PageList<Order> acquireHistoryOrder(int pageIndex, int pageSize,
			int agentId) throws Exception {
		// TODO Auto-generated method stub
		OrderExample example=new OrderExample();
		example.createCriteria().andCustomerIdEqualTo(String.valueOf(agentId));
   return (PageList<Order>) getPageList(OrderMapper.class, "selectByExample",
   		example, pageIndex, pageSize);
	}





}
