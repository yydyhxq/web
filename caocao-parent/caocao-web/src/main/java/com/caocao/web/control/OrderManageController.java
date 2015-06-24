package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caocao.core.model.BookOrder;
import com.caocao.core.service.OrderManageService;

@Controller
@RequestMapping("ordermanage")
public class OrderManageController {
	private static final Logger logger = LoggerFactory
			.getLogger(OrderManageController.class);
	
	@Resource
	private OrderManageService orderManageService;
	
	@RequestMapping(value = "/bookOrder", method = { RequestMethod.POST})
	public String QueryBookOrder(BookOrder bookOrder, ModelMap model) {
		List<BookOrder> bookList = orderManageService.SelectBookOrder(bookOrder);
		model.put("bookList", bookList);
		return ".jsp";
	}
	
	@RequestMapping(value = "/soonOrder", method = { RequestMethod.POST})
	public String QuerySoonOrder(BookOrder bookOrder, ModelMap model) {
		List<BookOrder> bookList = orderManageService.SelectSoonOrder(bookOrder);
		model.put("bookList", bookList);
		return ".jsp";
	}
	
	@RequestMapping(value = "/historyOrder", method = { RequestMethod.POST})
	public String QueryHistoryOrder(BookOrder bookOrder, ModelMap model) {
		List<BookOrder> historyList = orderManageService.SelectHistoryOrder(bookOrder);
		model.put("historyList", historyList);
		return ".jsp";
	}
}
