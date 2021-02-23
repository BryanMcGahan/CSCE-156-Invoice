package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DataConverter {

	public static void main(String[] args) {
		
		List<SaleItem> saleItemList = itemsReader();
		for(SaleItem item: saleItemList) {
			System.out.println(item.calcTotalPrice() + " " + item.getSaleItemCode()+ " " + item.getSaleItemName());
		}
		

	}

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
						Product newProduct = new Product(itemCode, itemType, itemName, itemBasePrice);
						saleItemList.add(newProduct);
					}else if(itemType.charAt(1) == 'V') {
						Service newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					}else if(itemType.charAt(1) == 'B') {
						Subscription newSubscription = new Subscription(itemCode, itemName, itemType, itemBasePrice);
						saleItemList.add(newSubscription);
					}
				} else {
					String itemCode = tokens[0];
					String itemType = tokens[1];
					String itemName = tokens[2];
					double itemBasePrice = 0;
					if (itemType.charAt(1) == 'G') {
						Product newProduct = new Product(itemCode, itemType, itemName, itemBasePrice);
						saleItemList.add(newProduct);
					}else if(itemType.charAt(1) == 'V') {
						Service newService = new Service(itemCode, itemName, itemType, 1, itemBasePrice);
						saleItemList.add(newService);
					}else if(itemType.charAt(1) == 'B') {
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

}
