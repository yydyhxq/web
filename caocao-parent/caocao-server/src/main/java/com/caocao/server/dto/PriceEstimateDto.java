package com.caocao.server.dto;

public class PriceEstimateDto {
	private double minprice;
	private double maxprice;

	public PriceEstimateDto(double minprice, double maxprice) {
		this.minprice = minprice;
		this.maxprice = maxprice;
	}

	public double getMinprice() {
		return minprice;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}

	public double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}
}
