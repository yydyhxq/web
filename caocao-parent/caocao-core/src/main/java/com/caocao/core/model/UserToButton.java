package com.caocao.core.model;

public class UserToButton {

	//主键
	private Integer id;
	
	//用户id
	private Integer userId;
	
	//按钮id
	private Integer buttonId;
	
	//菜单id
	private Integer menuId;

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

	public Integer getButtonId() {
		return buttonId;
	}

	public void setButtonId(Integer buttonId) {
		this.buttonId = buttonId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
