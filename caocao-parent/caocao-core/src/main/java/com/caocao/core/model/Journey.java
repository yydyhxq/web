package com.caocao.core.model;

import java.util.Date;

public class Journey {
	private Date getIn;
	private String startLocation;
	private String endLocation;
	private double costRealMoney;
	private String driverName;
	private String carNumber;
	private String carColor;
	private String carType;
	private double startPrice;
	private double distance;
	private double driverMinute;
	private double costMoney;
	private double discountMoney;

	public Date getGetIn() {
		return getIn;
	}

	public void setGetIn(Date getIn) {
		this.getIn = getIn;
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

	public double getCostRealMoney() {
		return costRealMoney;
	}

	public void setCostRealMoney(double costRealMoney) {
		this.costRealMoney = costRealMoney;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDriverMinute() {
		return driverMinute;
	}

	public void setDriverMinute(double driverMinute) {
		this.driverMinute = driverMinute;
	}

	public double getCostMoney() {
		return costMoney;
	}

	public void setCostMoney(double costMoney) {
		this.costMoney = costMoney;
	}

	public double getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(double discountMoney) {
		this.discountMoney = discountMoney;
	}

}
