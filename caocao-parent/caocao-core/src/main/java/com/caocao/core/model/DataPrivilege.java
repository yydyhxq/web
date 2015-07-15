package com.caocao.core.model;

public class DataPrivilege {

	//主键
	private Integer id;
	
	//用户id
	private Integer userId;
	
	//菜单id
	private Integer menuId;
	
	//查看数据权限1：本公司，2：所有
	private Integer hasData;

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

	public Integer getHasData() {
		return hasData;
	}

	public void setHasData(Integer hasData) {
		this.hasData = hasData;
	}
}
