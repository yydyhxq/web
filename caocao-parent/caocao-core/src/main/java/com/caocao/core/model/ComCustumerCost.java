package com.caocao.core.model;

import java.util.Date;

public class ComCustumerCost {
	
	private Integer id;

	private Date costDate;
	
	private Date costDateBegin;
	
	private Date costDateEnd;
	
	private Double startPrice;
	
	private Double distance;
	
	private Double driverMinutes; 
	
	private Double costMoney;
	
	private Double discountMoney;
	
	private Double realMoney;
	
	private String privilegeCode;
	
	private String carType;
	
	private String costCity;
	
	private String startLocation;
	
	private String endLocation;
	
	private String startAndEnd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCostDateBegin() {
		return costDateBegin;
	}

	public void setCostDateBegin(Date costDateBegin) {
		this.costDateBegin = costDateBegin;
	}

	public Date getCostDateEnd() {
		return costDateEnd;
	}

	public void setCostDateEnd(Date costDateEnd) {
		this.costDateEnd = costDateEnd;
	}

	public Date getCostDate() {
		return costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getDriverMinutes() {
		return driverMinutes;
	}

	public void setDriverMinutes(Double driverMinutes) {
		this.driverMinutes = driverMinutes;
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
	
}
