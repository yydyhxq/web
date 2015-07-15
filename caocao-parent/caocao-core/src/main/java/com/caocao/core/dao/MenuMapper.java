package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.Menu;
import com.caocao.core.model.UserToMenu;

public interface MenuMapper {

	List<Menu> QueryMenuList(UserToMenu userToMenu);
}
