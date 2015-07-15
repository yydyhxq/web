package com.caocao.core.model;

public class Menu {

	//菜单id
	private Integer id;
	
	//父id
	private Integer pid;
	
	//菜单名称
	private String name;
	
	//链接地址
	private String url;
	
	//菜单级别
	private Integer grade;
	
	//是否有下级菜单0：无，1：有
	private Integer hasNext;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getHasNext() {
		return hasNext;
	}

	public void setHasNext(Integer hasNext) {
		this.hasNext = hasNext;
	}
}
