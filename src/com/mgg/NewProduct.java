package com.mgg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a new product that is sold at mgg.
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("NewProduct")
public class NewProduct extends SaleItem {
	private double quantity = 0;
	

	public NewProduct(String saleItemCode, String saleItemName, String saleItemType, double basePrice, double quantity) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		this.quantity = quantity;
		
	}
	
	public NewProduct(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double calcTotalPrice() {
		double total = this.getBasePrice() * this.quantity;
		double discount = total * .8;
		double discountedCost = total - discount;
		double taxes = discountedCost * .725;
		double totalPrice = discountedCost + taxes; 
		return totalPrice;

	}

	@Override
	public String toString() {
		return "NewProduct [calcTotalPrice()=" + calcTotalPrice() + ", getSaleItemCode()=" + getSaleItemCode()
				+ ", getSaleItemName()=" + getSaleItemName() + ", getSaleItemType()=" + getSaleItemType()
				+ ", getBasePrice()=" + getBasePrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
