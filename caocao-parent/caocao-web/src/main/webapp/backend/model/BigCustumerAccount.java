package com.caocao.core.model;

public class BigCustumerAccount {
	
	private String custumerId;

	private String name;
	
	private Integer sex;
	
	private String phone;
	
	private Double totalOwnerMoney;
	
	private Double totalBusinessMoney;
	
	private Double totalMoney;
	
	private String company;

	public String getCustumerId() {
		return custumerId;
	}

	public void setCustumerId(String custumerId) {
		this.custumerId = custumerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getTotalOwnerMoney() {
		return totalOwnerMoney;
	}

	public void setTotalOwnerMoney(Double totalOwnerMoney) {
		this.totalOwnerMoney = totalOwnerMoney;
	}

	public Double getTotalBusinessMoney() {
		return totalBusinessMoney;
	}

	public void setTotalBusinessMoney(Double totalBusinessMoney) {
		this.totalBusinessMoney = totalBusinessMoney;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
