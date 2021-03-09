package com.mgg;

import java.util.HashMap;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class models a person from mgg's person's data
 * @author bryanmcgahan
 *
 */
@XStreamAlias("Person")
public class Person {
	
	private String personCode = null;
	private Character personType = null;
	private String firstName = null;
	private String lastName = null;
	private Address address;
	private List<String> emailAddresses;

	public Person(String personCode, Character personType, String  firstName, String lastName,Address address, List<String> emailAddresses) {
		super();
		this.personCode = personCode;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddresses = emailAddresses;
	}
	
	

	public Person(String personCode, Character personType, String firstName, String lastName, Address address) {
		super();
		this.personCode = personCode;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
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



	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.getLastName() + "" + this.getFirstName();
	}



	@Override
	public String toString() {
		return "Person [personCode=" + personCode + ", personType=" + personType + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", emailAddresses=" + emailAddresses + "]";
	}
	
	

}
