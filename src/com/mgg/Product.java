package com.mgg;

public class Product extends SaleItem {

	public Product(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		// TODO Auto-generated constructor stub
	}

	public void calcTotalPrice() {

		if (this.getSaleItemType().charAt(1) == 'N') {
			this.setTotalPrice(getBasePrice());
		} else {
			if (this.getSaleItemType().charAt(1) == 'U') {
				double discount = this.getBasePrice() * .8;
				this.setTotalPrice(this.getBasePrice() - discount);
			} else {
				this.setTotalPrice(0);
			}
		}

	}
}
