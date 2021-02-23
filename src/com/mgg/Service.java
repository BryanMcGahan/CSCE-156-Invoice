package com.mgg;

public class Service extends SaleItem{
	
	private double hoursCharged = 0;

	public Service(String saleItemCode, String saleItemName, String saleItemType, double basePrice,double hoursCharged) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		// TODO Auto-generated constructor stub
		this.hoursCharged = hoursCharged;
	}

	public double getHoursCharged() {
		return hoursCharged;
	}

	public void setHoursCharged(double hoursCharged) {
		this.hoursCharged = hoursCharged;
	}
	
	public double calcTotalPrice() {
		return this.totalPrice = this.getBasePrice()*this.hoursCharged;
	}
	
	
	

}
