package com.mgg;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.joda.time.Days;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a subscription that is sold at mgg.
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("Subscription")
public class Subscription extends SaleItem {
	private LocalDate subStartDate;
	private LocalDate subEndDate;

	public Subscription(String saleItemCode, String saleItemName, String saleItemType, double annualFee) {
		super(saleItemCode, saleItemName, saleItemType, annualFee);
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

	@Override
	public String toString() {
		return "Subscription [subStartDate=" + subStartDate + ", subEndDate=" + subEndDate + "]";
	}

	@Override
	public double calcTotalPrice() {
		double daysEffective = this.subStartDate.until(this.subEndDate, ChronoUnit.DAYS);
		double annualFee = ((daysEffective/365)*this.getBasePrice());
		
		return annualFee;
	}

}
