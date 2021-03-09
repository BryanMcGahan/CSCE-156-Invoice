package com.mgg;

import java.util.List;

public class Sale {
	private String saleCode = null;
	private Store store;
	private Person manager;
	private Person customer;
	private List<SaleItem> saleItemList;
	private double saleTotal = 0;
	
	
	public Sale(String saleCode, Store store, Person customer, Person manager, List<SaleItem> saleItemList) {
		super();
		this.store = store;
		this.saleCode = saleCode;
		this.manager = manager;
		this.customer = customer;
		this.saleItemList = saleItemList;
	
	}
	
	public Sale() {
		
	}


	public double getSaleTotal() {
		for(SaleItem item: this.saleItemList) {
			saleTotal+=item.calcTotalPrice();
		}
		return saleTotal;
	}


	public void setSaleTotal(double saleTotal) {
		this.saleTotal = saleTotal;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public String getSaleCode() {
		return saleCode;
	}


	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}


	public Person getManager() {
		return manager;
	}


	public void setManager(Person manager) {
		this.manager = manager;
	}


	public Person getCustomer() {
		return customer;
	}


	public void setCustomer(Person customer) {
		this.customer = customer;
	}


	public List<SaleItem> getSaleItemList() {
		return saleItemList;
	}


	public void setSaleItemList(List<SaleItem> saleItemList) {
		this.saleItemList = saleItemList;
	}
	
	


	@Override
	public String toString() {
		return "Sale [saleCode=" + saleCode + ", manager=" + manager + ", customer=" + customer + ", saleItemList="
				+ saleItemList + "]";
	}
	
	
	
	

}