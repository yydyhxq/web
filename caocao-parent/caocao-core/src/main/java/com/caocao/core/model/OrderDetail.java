package com.caocao.core.model;

public class OrderDetail {
	
	//订单编号
	private Integer orderId;

	private String startPlace;
	
	private String endPlace;
	
	private String carType;
	
	private String privilegeCode;
	
	private Double startPrice;
	
	private Double distance;
	
	private Double driverMinutes;
	
	private Double costMoney;
	
	private Double discountMoney;
	
	private Double costRealMoney;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
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

	public Double getCostRealMoney() {
		return costRealMoney;
	}

	public void setCostRealMoney(Double costRealMoney) {
		this.costRealMoney = costRealMoney;
	}
}
