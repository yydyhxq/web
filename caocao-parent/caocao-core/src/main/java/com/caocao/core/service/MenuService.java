package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Menu;
import com.caocao.core.model.UserToMenu;

public interface MenuService {

	List<Menu> queryMenuList(UserToMenu userToMenu);
	
	List<Menu> queryUserMenu(UserToMenu userToMenu);
}
