package com.mgg;

import java.util.HashMap;
import java.util.List;

public class Person {
	private String personCode = null;
	private Character personType = null;
	private HashMap<String, String> name;
	private Address address;
	private List<String> emailAddresses;

	public Person(String personCode, Character personType, HashMap<String, String> name,Address address, List<String> emailAddresses) {
		super();
		this.personCode = personCode;
		this.personType = personType;
		this.name = name;
		this.address = address;
		this.emailAddresses = emailAddresses;
	}
	
	

	public Person(String personCode, Character personType, HashMap<String, String> name, Address address) {
		super();
		this.personCode = personCode;
		this.personType = personType;
		this.name = name;
		this.address = address;
	}



	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Character getPersonType() {
		return personType;
	}

	public void setPersonType(Character personType) {
		this.personType = personType;
	}

	public HashMap<String, String> getName() {
		return name;
	}

	public void setName(HashMap<String, String> name) {
		this.name = name;
	}


	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	@Override
	public String toString() {
		return "Person [personCode=" + personCode + ", personType=" + personType + ", name=" + name + ", address="
				+ address + ", emailAddresses=" + emailAddresses + "]";
	}
	
	

}
