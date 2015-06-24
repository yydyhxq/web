package com.caocao.core.model;

public class MyWallet {
	private String payNum;
	private int payMethod;
	private int couponNum;
	private double banlance;

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}

	public int getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(int couponNum) {
		this.couponNum = couponNum;
	}

	public double getBanlance() {
		return banlance;
	}

	public void setBanlance(double banlance) {
		this.banlance = banlance;
	}
}
