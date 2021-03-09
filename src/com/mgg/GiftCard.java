package com.mgg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a gift card at mgg.
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("GiftCard")
public class GiftCard extends SaleItem {

	public GiftCard(String saleItemCode, String saleItemName, String saleItemType, double basePrice) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		
	}

	@Override
	public double calcTotalPrice() {

		return this.getBasePrice();
	}

	@Override
	public String toString() {
		return "GiftCard [calcTotalPrice()=" + calcTotalPrice() + ", getSaleItemCode()=" + getSaleItemCode()
				+ ", getSaleItemName()=" + getSaleItemName() + ", getSaleItemType()=" + getSaleItemType()
				+ ", getBasePrice()=" + getBasePrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
