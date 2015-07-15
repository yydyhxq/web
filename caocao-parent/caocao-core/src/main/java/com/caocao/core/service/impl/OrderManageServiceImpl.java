package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.OrderManageMapper;
import com.caocao.core.model.BookOrder;
import com.caocao.core.model.OrderDetail;
import com.caocao.core.service.OrderManageService;

@Service("orderManageService")
public class OrderManageServiceImpl implements OrderManageService {
	@Resource
	private OrderManageMapper orderManageMapper;
	
	public List<BookOrder> SelectBookOrder(BookOrder bookOrder) {
		List<BookOrder> bookList = orderManageMapper.SelectBookOrder(bookOrder);
		return bookList;
	}
	
	public List<BookOrder> SelectSoonOrder(BookOrder bookOrder) {
		List<BookOrder> soonList = orderManageMapper.SelectSoonOrder(bookOrder);
		return soonList;
	}
	
	public List<BookOrder> SelectHistoryOrder(BookOrder bookOrder) {
		List<BookOrder> historyList = orderManageMapper.SelectHistoryOrder(bookOrder);
		return historyList;
	}
	
	public OrderDetail SelectOrderDetail(OrderDetail orderDetail) {
		OrderDetail detail = orderManageMapper.SelectOrderDetail(orderDetail);
		return detail;
	}
}
