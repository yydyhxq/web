package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.BookOrder;
import com.caocao.core.model.OrderDetail;

public interface OrderManageMapper {

	List<BookOrder> SelectBookOrder(BookOrder record);
	
	List<BookOrder> SelectSoonOrder(BookOrder record);
	
	List<BookOrder> SelectHistoryOrder(BookOrder record);
	
	OrderDetail SelectOrderDetail(OrderDetail OrderDetail);
}
