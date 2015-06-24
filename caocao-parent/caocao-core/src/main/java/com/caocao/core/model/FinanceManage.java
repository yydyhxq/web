package com.caocao.core.model;

import java.util.Date;

public class FinanceManage {

	private String companyName;
	
	private String year;
	
	private String month;
	
	private Double totalMoney;
	
	private Double disTotalMoney;
	
	private Double incomeTotal;
	
	private Date costProduceDate;
	
	private Date costArriveDate;
	
	private Double totalBackMoney;
	
	private Double BaseIncomeMoney;
	
	private Double awardMoney;
	
	private Double inviteMoney;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getDisTotalMoney() {
		return disTotalMoney;
	}

	public void setDisTotalMoney(Double disTotalMoney) {
		this.disTotalMoney = disTotalMoney;
	}

	public Double getIncomeTotal() {
		return incomeTotal;
	}

	public void setIncomeTotal(Double incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	public Date getCostProduceDate() {
		return costProduceDate;
	}

	public void setCostProduceDate(Date costProduceDate) {
		this.costProduceDate = costProduceDate;
	}

	public Date getCostArriveDate() {
		return costArriveDate;
	}

	public void setCostArriveDate(Date costArriveDate) {
		this.costArriveDate = costArriveDate;
	}

	public Double getTotalBackMoney() {
		return totalBackMoney;
	}

	public void setTotalBackMoney(Double totalBackMoney) {
		this.totalBackMoney = totalBackMoney;
	}

	public Double getBaseIncomeMoney() {
		return BaseIncomeMoney;
	}

	public void setBaseIncomeMoney(Double baseIncomeMoney) {
		BaseIncomeMoney = baseIncomeMoney;
	}

	public Double getAwardMoney() {
		return awardMoney;
	}

	public void setAwardMoney(Double awardMoney) {
		this.awardMoney = awardMoney;
	}

	public Double getInviteMoney() {
		return inviteMoney;
	}

	public void setInviteMoney(Double inviteMoney) {
		this.inviteMoney = inviteMoney;
	}
}
