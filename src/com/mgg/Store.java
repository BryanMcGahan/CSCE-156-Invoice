package com.mgg;

import java.util.HashMap;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * The Store class models the data for a store in mgg's data files. 
 * @author bryanmcgahan
 *
 */
@XStreamAlias("Store")
public class Store {

	@XStreamAlias("Code")
	private String storeCode = null;
	@XStreamAlias("Manager")
	private Person manager;
	@XStreamAlias("Address")
	private Address storeAddress;

	public Store(String storeCode,Address storeAddress) {
		super();
		this.storeCode = storeCode;
		this.storeAddress = storeAddress;
	}
	
	public Store(String storeCode,Address storeAddress, Person manager) {
		super();
		this.storeCode = storeCode;
		this.storeAddress = storeAddress;
		this.manager = manager;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}


	public Address getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(Address storeAddress) {
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
		return "Store [storeCode=" + storeCode  + ", manager=" + manager
				+ ", storeAddress=" + storeAddress + "]";
	}



}
