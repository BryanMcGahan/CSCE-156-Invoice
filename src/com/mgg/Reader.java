package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * This class reads in data from flat data files and parse the data into Store,
 * Person, and SaleItem classes and subclasses and stores the objects into three
 * seperate lists.
 * 
 * @author bryanmcgahan
 *
 */
public class Reader {

	public static List<SaleItem> itemsReader() {

		List<SaleItem> saleItemList = new ArrayList<>();
		File itemsFile = new File("data/Items.csv");

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
					if (itemType.charAt(1) == 'N') {
						SaleItem newProduct = new NewProduct(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newProduct);
					} else if (itemType.charAt(1) == 'V') {
						SaleItem newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					} else if (itemType.charAt(1) == 'B') {
						SaleItem newSubscription = new Subscription(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newSubscription);
					} else if (itemType.charAt(1) == 'U') {
						SaleItem usedProduct = new UsedProduct(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(usedProduct);
					} else if (itemType.charAt(1) == 'G') {
						SaleItem giftCard = new GiftCard(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(giftCard);
					}
				} else {
					String itemCode = tokens[0];
					String itemType = tokens[1];
					String itemName = tokens[2];
					double itemBasePrice = 0;
					if (itemType.charAt(1) == 'N') {
						SaleItem newProduct = new NewProduct(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newProduct);
					} else if (itemType.charAt(1) == 'V') {
						SaleItem newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					} else if (itemType.charAt(1) == 'B') {
						SaleItem newSubscription = new Subscription(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newSubscription);
					} else if (itemType.charAt(1) == 'U') {
						SaleItem usedProduct = new UsedProduct(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(usedProduct);
					} else if (itemType.charAt(1) == 'G') {
						SaleItem giftCard = new GiftCard(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(giftCard);
					}

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saleItemList;

	}

	public static List<Person> personReader() {

		List<Person> personList = new ArrayList<>();
		File personFile = new File("data/Persons.csv");
		try {
			Scanner fileScanner = new Scanner(personFile);
			String numberOfEntries = fileScanner.nextLine();
			while (fileScanner.hasNextLine()) {
				String tokens[] = fileScanner.nextLine().split(",");
				if (tokens.length > 9) {
					String personCode = tokens[0];
					Character personType = tokens[1].charAt(0);
					String personLastName = tokens[2];
					String personFirstName = tokens[3];
					String street = tokens[4];
					String city = tokens[5];
					String state = tokens[6];
					String zipCode = tokens[7];
					String country = tokens[8];
					Address personAddress = new Address(street, city, state, zipCode, country);
					List<String> personEmails = new ArrayList<>();
					for (int i = 9; i < tokens.length; i++) {
						personEmails.add(tokens[i]);

					}
					Person person = new Person(personCode, personType, personFirstName, personLastName, personAddress,
							personEmails);
					personList.add(person);
				} else if (tokens.length < 9) {
					String personCode = tokens[0];
					Character personType = tokens[1].charAt(0);
					String personLastName = tokens[2];
					String personFirstName = tokens[3];
					String street = tokens[4];
					String city = tokens[5];
					String state = tokens[6];
					String zipCode = tokens[7];
					String country = tokens[8];
					Address personAddress = new Address(street, city, state, zipCode, country);
					Person person = new Person(personCode, personType, personFirstName, personLastName, personAddress);
					personList.add(person);

				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personList;

	}

	public static List<Store> storeReader() {

		List<Store> storeList = new ArrayList<>();
		File storeFile = new File("data/Stores.csv");
		try {
			Scanner fileScanner = new Scanner(storeFile);
			String numberOfEntries = fileScanner.nextLine();
			while (fileScanner.hasNextLine()) {
				String tokens[] = fileScanner.nextLine().split(",");
				String storeCode = tokens[0];
				String managerCode = tokens[1];
				String street = tokens[2];
				String city = tokens[3];
				String state = tokens[4];
				String zipCode = tokens[5];
				String country = tokens[6];
				Address storeAddress = new Address(street, city, state, zipCode, country);
				Store newStore = new Store(storeCode, storeAddress);
				storeList.add(newStore);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeList;

	}
	
	public static List<Sale> saleReader(){
		List<Sale> saleList = new ArrayList<Sale>();
		File saleFile = new File("data/Sales.csv");
		try {
			Scanner fileScanner = new Scanner(saleFile);
			String numberOfEntries = fileScanner.nextLine();
			while(fileScanner.hasNextLine()) {
				Sale newSale = new Sale();
				String tokens[] = fileScanner.nextLine().split(",");
				String saleCode = tokens[0];
				newSale.setSaleCode(saleCode);
				List<Store> storeList = Reader.storeReader();
				for(Store store: storeList) {
					if(store.getStoreCode().equals(tokens[1])) {
						newSale.setStore(store);

					}
				}
				List<Person> personList = Reader.personReader();
				for(Person customer: personList) {
					if(customer.getPersonCode().equals(tokens[2])) {
						newSale.setCustomer(customer);
					}
				}
				for(Person manager: personList) {
					if(manager.getPersonCode().equals(tokens[3])) {
						newSale.setManager(manager);
					}
				}
				
				List<SaleItem> items = Reader.itemsReader();
				List<SaleItem> saleItemsList = new ArrayList<SaleItem>();
				for(int i =4; i<tokens.length;i++) {
					String saleItemCode = tokens[i];
					for(SaleItem item: items) {
						if(saleItemCode.equals(item.getSaleItemCode())) {
							if(item.getSaleItemType().charAt(1) == 'N'){
								double quantity = Double.parseDouble(tokens[i+1]);
								SaleItem newProduct = new NewProduct(item.getSaleItemCode(), item.getSaleItemName(), item.getSaleItemType(), item.getBasePrice(), quantity);
								saleItemsList.add(newProduct);
							}else if(item.getSaleItemType().charAt(1)=='U') {
								double quantity = Double.parseDouble(tokens[i+1]);
								SaleItem usedProduct = new UsedProduct(item.getSaleItemCode(), item.getSaleItemName(), item.getSaleItemType(), item.getBasePrice(), quantity);
								saleItemsList.add(usedProduct);
							}else if(item.getSaleItemType().charAt(1)=='V') {
								 for(Person serviceEmployee: personList) {
									 if(tokens[i+1].equals(serviceEmployee.getPersonCode())) {
										 double serviceHours = Double.parseDouble(tokens[i+2]);
										 SaleItem service = new Service(item.getSaleItemCode(), item.getSaleItemName(), item.getSaleItemType(), serviceHours, item.getBasePrice(), serviceEmployee);
										 saleItemsList.add(service);
									 }
								 }
							}else if(item.getSaleItemType().charAt(1)=='B') {
								LocalDate startDate = LocalDate.parse(tokens[i+1]);
								LocalDate endDate = LocalDate.parse(tokens[i+2]);
								SaleItem newSub = new Subscription(item.getSaleItemCode(), item.getSaleItemName(), item.getSaleItemType(), item.getBasePrice(), startDate, endDate);
								saleItemsList.add(newSub);
							}
						}
					}
					
					newSale.setSaleItemList(saleItemsList);
				}
				
				saleList.add(newSale);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saleList;
		
	}

}
