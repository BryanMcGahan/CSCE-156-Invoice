package com.mgg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a item that is invoiced on a sale list at mgg.
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("SaleItem")
public abstract class SaleItem {
	@XStreamAlias("Code")
	private String saleItemCode = null;
	@XStreamAlias("Name")
	private String saleItemName = null;
	@XStreamAlias("Type")
	private String saleItemType = null;
	@XStreamAlias("Base" + "Price")
	private double basePrice = 0;

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

	public abstract double calcTotalPrice();

}
