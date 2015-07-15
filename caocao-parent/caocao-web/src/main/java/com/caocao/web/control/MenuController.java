package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caocao.core.model.Menu;
import com.caocao.core.model.UserToMenu;
import com.caocao.core.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
	private static final Logger logger = LoggerFactory
			.getLogger(MenuController.class);
	@Resource
	private MenuService menuService;
	
	@RequestMapping("/querymenus")
	public void QueryMenuList(@ModelAttribute UserToMenu userToMenu, HttpSession session) {
		List<Menu> menuList = menuService.QueryMenuList(userToMenu);
		session.setAttribute("menuList", menuList);
	}
}
