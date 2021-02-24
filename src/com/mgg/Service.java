package com.mgg;

public class Service extends SaleItem {
	private double hoursCharged = 0;
	

	public Service(String saleItemCode, String saleItemName, String saleItemType, double hoursCharged, double hourlyRate) {
		super(saleItemCode, saleItemName, saleItemType, hourlyRate);
		// TODO Auto-generated constructor stub
		this.hoursCharged = hoursCharged;
		
		
	}


	public double getHoursCharged() {
		return hoursCharged;
	}


	public void setHoursCharged(double hoursCharged) {
		this.hoursCharged = hoursCharged;
	}
	
	public void calcTotalPrice() {
		this.setTotalPrice(this.hoursCharged*this.getBasePrice());
	}

}
