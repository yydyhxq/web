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
import com.caocao.core.service.OrderManageService;

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
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/soonorder")
	@ResponseBody
	public Map<String, Object> QuerySoonOrder(BookOrder bookOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookOrder> list = orderManageService.SelectSoonOrder(bookOrder);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/historyorder")
	@ResponseBody
	public Map<String, Object> QueryHistoryOrder(BookOrder bookOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BookOrder> list = orderManageService.SelectHistoryOrder(bookOrder);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
}
