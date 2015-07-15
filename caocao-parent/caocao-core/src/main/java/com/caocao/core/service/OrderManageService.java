package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.BookOrder;
import com.caocao.core.model.OrderDetail;

public interface OrderManageService {

	List<BookOrder> SelectBookOrder(BookOrder bookOrder);
	
	List<BookOrder> SelectSoonOrder(BookOrder bookOrder);
	
	List<BookOrder> SelectHistoryOrder(BookOrder bookOrder);
	
	OrderDetail SelectOrderDetail(OrderDetail orderDetail);
}
