package com.caocao.core.model;

import java.util.Date;

public class BookOrder {

	private Integer orderId;
	
	private String passengerName;
	
	private String passengerPhone;
	
	private Date appointmentTime;
	
	private Date appointmentBegin;
	
	private Date appointmentEnd;
	
	private Date appointStartTime;
	
	private Date appointStartBegin;
	
	private Date appointStartEnd;
	
	private Date orderCreateBegin;
	
	private Date orderCreateEnd;
	
	private String startPlace;
	
	private String destination;
	
	private String driverName;
	
	private String driverPhone;
	
	//订单状态
	private Integer orderStatus;
	
	//订单状态
	private String orderStatusStr;
	
	private String costCity;
	
	private Integer isBig;
	
	private Date orderProduceTime;
	
	private Date onCarTime;
	
	private Double costMoney;
	
	private String isBigStr;
	
	//订单产生时间
	private String orderProduceTimeStr;
	
	//预约时间
	private String appointmentTimeStr;
	
	//预约出发时间
	private String appointStartTimeStr;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
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

	public Date getAppointmentBegin() {
		return appointmentBegin;
	}

	public void setAppointmentBegin(Date appointmentBegin) {
		this.appointmentBegin = appointmentBegin;
	}

	public Date getAppointmentEnd() {
		return appointmentEnd;
	}

	public void setAppointmentEnd(Date appointmentEnd) {
		this.appointmentEnd = appointmentEnd;
	}

	public Date getAppointStartTime() {
		return appointStartTime;
	}

	public void setAppointStartTime(Date appointStartTime) {
		this.appointStartTime = appointStartTime;
	}

	public Date getAppointStartBegin() {
		return appointStartBegin;
	}

	public void setAppointStartBegin(Date appointStartBegin) {
		this.appointStartBegin = appointStartBegin;
	}

	public Date getAppointStartEnd() {
		return appointStartEnd;
	}

	public void setAppointStartEnd(Date appointStartEnd) {
		this.appointStartEnd = appointStartEnd;
	}

	public Date getOrderCreateBegin() {
		return orderCreateBegin;
	}

	public void setOrderCreateBegin(Date orderCreateBegin) {
		this.orderCreateBegin = orderCreateBegin;
	}

	public Date getOrderCreateEnd() {
		return orderCreateEnd;
	}

	public void setOrderCreateEnd(Date orderCreateEnd) {
		this.orderCreateEnd = orderCreateEnd;
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

	public String getOrderStatusStr() {
		return orderStatusStr;
	}

	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
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

	public String getIsBigStr() {
		return isBigStr;
	}

	public void setIsBigStr(String isBigStr) {
		this.isBigStr = isBigStr;
	}

	public String getOrderProduceTimeStr() {
		return orderProduceTimeStr;
	}

	public void setOrderProduceTimeStr(String orderProduceTimeStr) {
		this.orderProduceTimeStr = orderProduceTimeStr;
	}

	public String getAppointmentTimeStr() {
		return appointmentTimeStr;
	}

	public void setAppointmentTimeStr(String appointmentTimeStr) {
		this.appointmentTimeStr = appointmentTimeStr;
	}

	public String getAppointStartTimeStr() {
		return appointStartTimeStr;
	}

	public void setAppointStartTimeStr(String appointStartTimeStr) {
		this.appointStartTimeStr = appointStartTimeStr;
	}
}
