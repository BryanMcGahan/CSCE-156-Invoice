package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Reader {
	
	public static List<SaleItem> itemsReader() {

		List<SaleItem> saleItemList = new ArrayList<>();
		File itemsFile = new File("data/items.csv");
		
		try {
			Scanner fileScanner = new Scanner(itemsFile);
			String numberOfEntries = fileScanner.nextLine();
			while (fileScanner.hasNextLine()) {
				String tokens[] = fileScanner.nextLine().split(",");
				if (tokens.length > 3) {
					String itemCode = tokens[0];
					String itemType = tokens[1];
					String itemName = tokens[2];
					double itemBasePrice = Double.parseDouble(tokens[3]);
					if (itemType.charAt(0) == 'P') {
						Product newProduct = new Product(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newProduct);
					} else if (itemType.charAt(1) == 'V') {
						Service newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					} else if (itemType.charAt(1) == 'B') {
						Subscription newSubscription = new Subscription(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newSubscription);
					}
				} else {
					String itemCode = tokens[0];
					String itemType = tokens[1];
					String itemName = tokens[2];
					double itemBasePrice = 0;
					if (itemType.charAt(1) == 'G') {
						Product newProduct = new Product(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newProduct);
					} else if (itemType.charAt(1) == 'V') {
						Service newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					} else if (itemType.charAt(1) == 'B') {
						Subscription newSubscription = new Subscription(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newSubscription);
					}

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saleItemList;

	}
	
	public static List<Person> personReader(){
		
		List<Person> personList = new ArrayList<>();
		File personFile = new File("data/Persons.csv");
		try {
			Scanner fileScanner = new Scanner(personFile);
			String numberOfEntries = fileScanner.nextLine();
			while(fileScanner.hasNextLine()) {
				String tokens[] = fileScanner.nextLine().split(",");
				if(tokens.length > 9) {
					String personCode = tokens[0];
					Character personType = tokens[1].charAt(0);
					String personLastName = tokens[2];
					String personFirstName = tokens[3];
					HashMap<String,String> personName = new HashMap<>();
					personName.put("last name", personLastName);
					personName.put("first name", personFirstName);
					String street = tokens[4];
					String city = tokens[5];
					String state = tokens[6];
					String zipCode = tokens[7];
					String country = tokens[8];
					Address personAddress = new Address(street, city, state, zipCode, country);
					List<String> personEmails = new ArrayList<>();
					for(int i = 9; i<tokens.length;i++) {
						personEmails.add(tokens[i]);
						
					}
					Person person = new Person(personCode, personType, personName, personAddress, personEmails);
					personList.add(person);
				}else if(tokens.length < 9) {
					String personCode = tokens[0];
					Character personType = tokens[1].charAt(0);
					String personLastName = tokens[2];
					String personFirstName = tokens[3];
					HashMap<String,String> personName = new HashMap<>();
					personName.put("last name", personLastName);
					personName.put("first name", personFirstName);
					String street = tokens[4];
					String city = tokens[5];
					String state = tokens[6];
					String zipCode = tokens[7];
					String country = tokens[8];
					Address personAddress = new Address(street, city, state, zipCode, country);
					Person person = new Person(personCode, personType, personName, personAddress);
					personList.add(person);
					
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personList;
		
	}

	public static List<Store> storeReader(){
		
		List<Store> storeList = new ArrayList<>();
		File storeFile = new File("data/Stores.csv");
		try {
			Scanner fileScanner = new Scanner(storeFile);
			String numberOfEntries = fileScanner.nextLine();
			while(fileScanner.hasNextLine()) {
				String tokens[] = fileScanner.nextLine().split(",");
				String storeCode = tokens[0];
				String managerCode = tokens[1];
				String street = tokens[2];
				String city = tokens[3];
				String state = tokens[4];
				String zipCode = tokens[5];
				String country = tokens[6];
				Address storeAddress = new Address(street, city, state, zipCode, country);
				Store newStore = new Store(storeCode, managerCode, storeAddress);
				storeList.add(newStore);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeList;
		
	}
	
	

}
