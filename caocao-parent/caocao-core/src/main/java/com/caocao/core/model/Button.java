package com.caocao.core.model;

public class Button {

	//主键
	private Integer id;
	
	//按钮名称
	private String name;
	
	//按钮url
	private String url;
	
	//此所属的菜单id
	private Integer menuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
