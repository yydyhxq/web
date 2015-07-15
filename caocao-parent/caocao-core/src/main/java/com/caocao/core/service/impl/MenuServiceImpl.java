package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.MenuMapper;
import com.caocao.core.model.Menu;
import com.caocao.core.model.UserToMenu;
import com.caocao.core.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;

	public List<Menu> QueryMenuList(UserToMenu userToMenu) {
		List<Menu> list = menuMapper.QueryMenuList(userToMenu);
		return list;
	}
}
