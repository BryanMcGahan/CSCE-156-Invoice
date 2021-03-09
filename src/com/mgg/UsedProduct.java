package com.mgg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a used item that is sold at mgg.
 * 
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("UsedProduct")
public class UsedProduct extends SaleItem {
	private double quantity = 0;


	public UsedProduct(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		
	}
		
	public UsedProduct(String saleItemCode, String saleItemName, String saleItemType, double basePrice, double quantity) {
		super(saleItemCode,saleItemName,saleItemType,basePrice);
		this.quantity = quantity;
	
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public double calcTotalPrice() {
		double total = this.getBasePrice() * this.quantity;
		double discount = total * .8;
		double discountedCost = total - discount;
		double taxes = discountedCost * .285;
		double totalPrice = discountedCost + taxes; 
		return totalPrice;
	}

	@Override
	public String toString() {
		return "UsedProduct [quantity=" + quantity + ", getQuantity()=" + getQuantity() + ", calcTotalPrice()="
				+ calcTotalPrice() + ", getSaleItemCode()=" + getSaleItemCode() + ", getSaleItemName()="
				+ getSaleItemName() + ", getSaleItemType()=" + getSaleItemType() + ", getBasePrice()=" + getBasePrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
