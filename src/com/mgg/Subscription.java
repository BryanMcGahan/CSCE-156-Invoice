package com.mgg;

import java.time.LocalDate;

public class Subscription extends SaleItem {
	private LocalDate subStartDate;
	private LocalDate subEndDate;

	public Subscription(String saleItemCode, String saleItemName, String saleItemType, double annualFee) {
		super(saleItemCode, saleItemName, saleItemType, annualFee);
		// TODO Auto-generated constructor stub
	}

	public Subscription(String saleItemCode, String saleItemName, String saleItemType, double basePrice,
			LocalDate subStartDate, LocalDate subEndDate) {
		super(saleItemCode, saleItemName, saleItemType, basePrice);
		this.subStartDate = subStartDate;
		this.subEndDate = subEndDate;
	}

	public LocalDate getSubStartDate() {
		return subStartDate;
	}

	public void setSubStartDate(LocalDate subStartDate) {
		this.subStartDate = subStartDate;
	}

	public LocalDate getSubEndDate() {
		return subEndDate;
	}

	public void setSubEndDate(LocalDate subEndDate) {
		this.subEndDate = subEndDate;
	}
	
}
