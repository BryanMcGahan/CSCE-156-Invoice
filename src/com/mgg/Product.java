package com.mgg;

public class Product extends SaleItem{

	public Product(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		// TODO Auto-generated constructor st
		
	}
	
	public double calcTotalPrice() {
		
		if(this.getSaleItemType().charAt(1)=='N') {
			this.totalPrice = this.getBasePrice();
		}else if(this.getSaleItemType().charAt(1)=='U') {
			double discount = this.getBasePrice()*.8;
			this.totalPrice = this.getBasePrice()-discount;
		}else {
			this.totalPrice = 0;
		}
		
		return totalPrice;
		
	}

	
	

}
