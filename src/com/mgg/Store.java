package com.mgg;

import java.util.HashMap;
import java.util.List;

public class Store {

	private String storeCode = null;
	private String managerCode = null;
	private Person manager;
	private HashMap<String, String> storeAddress;

	public Store(String storeCode, String managerCode, HashMap<String, String> storeAddress) {
		super();
		this.storeCode = storeCode;
		this.managerCode = managerCode;
		this.storeAddress = storeAddress;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public HashMap<String, String> getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(HashMap<String, String> storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", managerCode=" + managerCode + ", manager=" + manager
				+ ", storeAddress=" + storeAddress + "]";
	}



}
