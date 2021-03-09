package com.mgg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a service that is sold at mgg.
 * 
 * This class uses hours charged and the hourly rate of a service to calculate
 * the total price of the service.
 * 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("Service")
public class Service extends SaleItem {
	private double hoursCharged = 0;
	private double hourlyRate = 0;
	private Person serviceEmployee;

	public Service(String saleItemCode, String saleItemName, String saleItemType, double hoursCharged,
			double hourlyRate) {
		super(saleItemCode, saleItemName, saleItemType, hourlyRate);
		this.hoursCharged = hoursCharged;
		this.hourlyRate = hourlyRate;

	}
	
	public Service(String saleItemCode, String saleItemName, String saleItemType, double hoursCharged, double hourlyRate, Person serviceEmployee) {
		super(saleItemCode, saleItemName, saleItemType, hourlyRate);
		this.hoursCharged = hoursCharged;
		this.hourlyRate = hourlyRate;
		this.serviceEmployee = serviceEmployee;
	}

	public double getHoursCharged() {
		return hoursCharged;
	}

	public Person getServiceEmployee() {
		return serviceEmployee;
	}

	public void setServiceEmployee(Person serviceEmployee) {
		this.serviceEmployee = serviceEmployee;
	}

	public void setHoursCharged(double hoursCharged) {
		this.hoursCharged = hoursCharged;
	}

	@Override
	public double calcTotalPrice() {

		double totalPrice = this.hoursCharged * this.hourlyRate;

		return totalPrice;
	}

	@Override
	public String toString() {
		return "Service [hoursCharged=" + hoursCharged + ", hourlyRate=" + hourlyRate + ", serviceEmployee="
				+ serviceEmployee + ", getHoursCharged()=" + getHoursCharged() + ", getServiceEmployee()="
				+ getServiceEmployee() + ", calcTotalPrice()=" + calcTotalPrice() + ", getSaleItemCode()="
				+ getSaleItemCode() + ", getSaleItemName()=" + getSaleItemName() + ", getSaleItemType()="
				+ getSaleItemType() + ", getBasePrice()=" + getBasePrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
