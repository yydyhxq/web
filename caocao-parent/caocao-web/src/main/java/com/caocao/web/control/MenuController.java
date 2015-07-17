package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public List<Menu> queryMenuList(@ModelAttribute UserToMenu userToMenu, HttpSession session) {
		List<Menu> menuList = menuService.queryMenuList(userToMenu);
		session.setAttribute("menuList", menuList);
		return menuList;
	}
	
	@RequestMapping("/usermenu")
	@ResponseBody
	public List<Menu> queryUserMenu(@ModelAttribute UserToMenu userToMenu, HttpSession session) {
		List<Menu> userMenuList = menuService.queryUserMenu(userToMenu);
		return userMenuList;
	}
}
