package com.caocao.web.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.BookOrder;
import com.caocao.core.model.OrderDetail;
import com.caocao.core.service.OrderManageService;
import com.caocao.web.constant.DateAndStr;
import com.caocao.web.constant.OrderCst;
import com.caocao.web.constant.VipCustumerCst;

@Controller
@RequestMapping("ordermanage")
public class OrderManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(OrderManageController.class);
	
	@Resource
	private OrderManageService orderManageService;
	
	@RequestMapping(value = "/bookorder")
	@ResponseBody
	public Map<String, Object> QueryBookOrder(BookOrder bookOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookOrder> list = orderManageService.SelectBookOrder(bookOrder);
		for(int i=0; i<list.size(); i++) {
			if(null != list.get(i).getIsBig()) {
				if(1 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.NO);
				} else if(2 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.YES);
				}
			}
			if (null != list.get(i).getOrderStatus()) {
				if(1 == list.get(i).getOrderStatus()) {
					list.get(i).setOrderStatusStr(OrderCst.OrderStatus.ONE);
				} else if (1 == list.get(i).getOrderStatus()) {
					list.get(i).setOrderStatusStr(OrderCst.OrderStatus.TWO);
				} else if (1 == list.get(i).getOrderStatus()) {
					list.get(i).setOrderStatusStr(OrderCst.OrderStatus.THREE);
				} else if (1 == list.get(i).getOrderStatus()) {
					list.get(i).setOrderStatusStr(OrderCst.OrderStatus.FOUR);
				}
			}
			if(null != list.get(i).getAppointmentTime()) {
				list.get(i).setAppointmentTimeStr(DateAndStr.DateToStrHour(list.get(i).getAppointmentTime()));
			}
			if(null != list.get(i).getAppointStartTime()) {
				list.get(i).setAppointStartTimeStr(DateAndStr.DateToStrHour(list.get(i).getAppointStartTime()));
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/soonorder")
	@ResponseBody
	public Map<String, Object> QuerySoonOrder(BookOrder bookOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookOrder> list = orderManageService.SelectSoonOrder(bookOrder);
		for(int i=0; i<list.size(); i++) {
			if(null != list.get(i).getIsBig()) {
				if(1 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.NO);
				} else if(2 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.YES);
				}
			}
			
			if(null != list.get(i).getOrderProduceTime()) {
				list.get(i).setOrderProduceTimeStr(DateAndStr.DateToStrHour(list.get(i).getOrderProduceTime()));
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/historyorder")
	@ResponseBody
	public Map<String, Object> QueryHistoryOrder(BookOrder bookOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookOrder> list = orderManageService.SelectHistoryOrder(bookOrder);
		for(int i=0; i<list.size(); i++) {
			if(null != list.get(i).getIsBig()) {
				if(1 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.NO);
				} else if(2 == list.get(i).getIsBig()) {
					list.get(i).setIsBigStr(VipCustumerCst.vipCustumer.YES);
				}
			}
			
			if(null != list.get(i).getOrderProduceTime()) {
				list.get(i).setOrderProduceTimeStr(DateAndStr.DateToStrHour(list.get(i).getOrderProduceTime()));
			}
		}
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/orderdetail")
	@ResponseBody
	public OrderDetail QueryOrderDetail(OrderDetail orderDetail) {
		OrderDetail detail = null;
		try{
			detail = orderManageService.SelectOrderDetail(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}
}
