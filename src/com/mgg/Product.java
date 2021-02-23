package com.mgg;

public class Product implements SaleItem {
	
	private String saleItemCode = null;
	private String saleItemType =  null;
	private String saleItemName = null;
	private double basePrice = 0;
	private double totalPrice = 0;
	
	

	public Product(String saleItemCode, String saleItemType, String saleItemName, double basePrice) {
		super();
		this.saleItemCode = saleItemCode;
		this.saleItemType = saleItemType;
		this.saleItemName = saleItemName;
		this.basePrice = basePrice;
	}



	@Override
	public double calcTotalPrice() {
		
		if(this.saleItemType.equals("PN")) {
			this.totalPrice = this.basePrice;
		}else if(this.saleItemType.equals("PU")) {
			double discount = this.basePrice * .8;
			this.totalPrice = this.basePrice - discount;
					
		}
		
		return totalPrice;
	}




	public void setSaleItemCode(String saleItemNumber) {
		this.saleItemCode = saleItemNumber;
	}



	public void setSaleItemType(String productType) {
		this.saleItemType = productType;
	}


	public void setSaleItemName(String productName) {
		this.saleItemName = productName;
	}



	public double getBasePrice() {
		return basePrice;
	}



	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}



	@Override
	public String getSaleItemCode() {
		return saleItemCode;
	}



	@Override
	public String getSaleItemName() {
		return saleItemName;
	}



	@Override
	public String getSaleItemType() {
		return saleItemType;
	}





}
