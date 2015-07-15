package com.caocao.core.model;

public class UserToMenu {

	//主键
	private Integer id;
	
	//用户id
	private Integer userId;
	
	//菜单id
	private Integer menuId;
	
	//菜单父id
	private Integer menuPid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuPid() {
		return menuPid;
	}

	public void setMenuPid(Integer menuPid) {
		this.menuPid = menuPid;
	}
}
