package com.caocao.core.model;

import java.util.Date;

public class BigCustumerCost {
	
	private Integer custumerId;

	private Date costDate;
	
	private Double costMoney;
	
	private Double discountMoney;
	
	private Double realMoney;
	
	private String privilegeCode;
	
	private String carType;
	
	private String costCity;
	
	private String startLocation;
	
	private String endLocation;
	
	private String startAndEnd;
	
	private Integer owner;

	public Integer getCustumerId() {
		return custumerId;
	}

	public void setCustumerId(Integer custumerId) {
		this.custumerId = custumerId;
	}

	public Date getCostDate() {
		return costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public Double getCostMoney() {
		return costMoney;
	}

	public void setCostMoney(Double costMoney) {
		this.costMoney = costMoney;
	}

	public Double getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(Double discountMoney) {
		this.discountMoney = discountMoney;
	}

	public Double getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(Double realMoney) {
		this.realMoney = realMoney;
	}

	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCostCity() {
		return costCity;
	}

	public void setCostCity(String costCity) {
		this.costCity = costCity;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public String getStartAndEnd() {
		return startAndEnd;
	}

	public void setStartAndEnd(String startAndEnd) {
		this.startAndEnd = startAndEnd;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	
}
