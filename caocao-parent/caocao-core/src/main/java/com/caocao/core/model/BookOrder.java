package com.caocao.core.model;

import java.util.Date;

public class BookOrder {

	private String orderId;
	
	private String passengerName;
	
	private String passengerPhone;
	
	private Date appointmentTime;
	
	private Date appointStartTime;
	
	private String startPlace;
	
	private String destination;
	
	private String driverName;
	
	private String driverPhone;
	
	private Integer orderStatus;
	
	private String costCity;
	
	private Integer isBig;
	
	private Date orderProduceTime;
	
	private Date onCarTime;
	
	private Double costMoney;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Date getAppointStartTime() {
		return appointStartTime;
	}

	public void setAppointStartTime(Date appointStartTime) {
		this.appointStartTime = appointStartTime;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCostCity() {
		return costCity;
	}

	public void setCostCity(String costCity) {
		this.costCity = costCity;
	}

	public Integer getIsBig() {
		return isBig;
	}

	public void setIsBig(Integer isBig) {
		this.isBig = isBig;
	}

	public Date getOrderProduceTime() {
		return orderProduceTime;
	}

	public void setOrderProduceTime(Date orderProduceTime) {
		this.orderProduceTime = orderProduceTime;
	}

	public Date getOnCarTime() {
		return onCarTime;
	}

	public void setOnCarTime(Date onCarTime) {
		this.onCarTime = onCarTime;
	}

	public Double getCostMoney() {
		return costMoney;
	}

	public void setCostMoney(Double costMoney) {
		this.costMoney = costMoney;
	}
	
}
