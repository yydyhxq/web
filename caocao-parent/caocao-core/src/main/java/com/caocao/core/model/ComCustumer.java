package com.caocao.core.model;

import java.util.Date;

public class ComCustumer {

	private String name;
	
	private Integer sex;
	
	private String phone;
	
	private Integer times;
	
	private Double costMoney;
	
	private Integer rank;
	
	private String inviteCode;
	
	private String evaluateRate;
	
	private String carType;
	
	private Date registerDate;
	
	private String costCity;

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

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Double getCostMoney() {
		return costMoney;
	}

	public void setCostMoney(Double costMoney) {
		this.costMoney = costMoney;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getEvaluateRate() {
		return evaluateRate;
	}

	public void setEvaluateRate(String evaluateRate) {
		this.evaluateRate = evaluateRate;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getCostCity() {
		return costCity;
	}

	public void setCostCity(String costCity) {
		this.costCity = costCity;
	}
	
}
