package com.mgg;

public class Service implements SaleItem {
	
	private String saleItemCode = null;
	private String saleItemName = null;
	private String saleItemType = null;
	private double hoursCharged = 0;
	private double basePrice = 0;
	private double totalPrice = 0;
	

	public Service(String saleItemCode, String saleItemName, String saleItemType, double hoursCharged,
			double basePrice) {
		super();
		this.saleItemCode = saleItemCode;
		this.saleItemName = saleItemName;
		this.saleItemType = saleItemType;
		this.hoursCharged = hoursCharged;
		this.basePrice = basePrice;
	}
	
	

	public double getHoursCharged() {
		return hoursCharged;
	}



	public void setHoursCharged(double hoursCharged) {
		this.hoursCharged = hoursCharged;
	}



	public double getBasePrice() {
		return basePrice;
	}



	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
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
		
		this.totalPrice = this.basePrice * this.hoursCharged;
		
		return totalPrice;
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
