package com.caocao.core.model;

public class Privilege {

	//菜单id
	private Integer id;
	
	//菜单父id
	private Integer pid;
	
	//菜单名称
	private String name;
	
	//用户id
	private String userId;
	
	//是否勾选
	private Boolean checked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
