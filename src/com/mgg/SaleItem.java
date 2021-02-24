package com.mgg;

public class SaleItem {
	private String saleItemCode = null;
	private String saleItemName = null;
	private String saleItemType = null;
	private double basePrice = 0;
	private double totalPrice = 0;
	
	
	public SaleItem(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super();
		this.saleItemCode = saleItemCode;
		this.saleItemName = saleItemName;
		this.saleItemType = saleItemType;
		this.basePrice = basePrice;
	}


	public String getSaleItemCode() {
		return saleItemCode;
	}


	public void setSaleItemCode(String saleItemCode) {
		this.saleItemCode = saleItemCode;
	}


	public String getSaleItemName() {
		return saleItemName;
	}


	public void setSaleItemName(String saleItemName) {
		this.saleItemName = saleItemName;
	}


	public String getSaleItemType() {
		return saleItemType;
	}


	public void setSaleItemType(String saleItemType) {
		this.saleItemType = saleItemType;
	}


	public double getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	

}
