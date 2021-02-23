package com.mgg;

import java.time.LocalDate;

public class Subscription implements SaleItem {
	
	private String saleItemCode = null;
	private String saleItemName = null;
	private String saleItemType = null;
	private LocalDate subStartDate = null;
	private LocalDate subEndDate = null;
	private double annualFee = 0;
	private double totalPrice = 0;
	
	

	public Subscription(String saleItemCode, String saleItemName, String saleItemType, LocalDate subStartDate,
			LocalDate subEndDate, double annualFee) {
		super();
		this.saleItemCode = saleItemCode;
		this.saleItemName = saleItemName;
		this.saleItemType = saleItemType;
		this.subStartDate = subStartDate;
		this.subEndDate = subEndDate;
		this.annualFee = annualFee;
	}
	
	

	public Subscription(String saleItemCode, String saleItemName, String saleItemType, double annualFee) {
		super();
		this.saleItemCode = saleItemCode;
		this.saleItemName = saleItemName;
		this.saleItemType = saleItemType;
		this.annualFee = annualFee;
	}

	


	public LocalDate getSubStartDate() {
		return subStartDate;
	}



	public void setSubStartDate(LocalDate subStartDate) {
		this.subStartDate = subStartDate;
	}



	public LocalDate getSubEndDate() {
		return subEndDate;
	}



	public void setSubEndDate(LocalDate subEndDate) {
		this.subEndDate = subEndDate;
	}



	public double getAnnualFee() {
		return annualFee;
	}



	public void setAnnualFee(double annualFee) {
		this.annualFee = annualFee;
	}



	public void setSaleItemCode(String saleItemCode) {
		this.saleItemCode = saleItemCode;
	}



	public void setSaleItemName(String saleItemName) {
		this.saleItemName = saleItemName;
	}



	public void setSaleItemType(String saleItemType) {
		this.saleItemType = saleItemType;
	}



	@Override
	public double calcTotalPrice() {
		// TODO Auto-generated method stub
		return annualFee;
	}

	@Override
	public String getSaleItemCode() {
		// TODO Auto-generated method stub
		return saleItemCode;
	}

	@Override
	public String getSaleItemName() {
		// TODO Auto-generated method stub
		return saleItemName;
	}

	@Override
	public String getSaleItemType() {
		// TODO Auto-generated method stub
		return saleItemType;
	}

}
