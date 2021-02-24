package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;


public class DataConverter {

	public static void main(String[] args) {

		List<SaleItem> saleItemList = Reader.itemsReader();
		List<Person> personList = Reader.personReader();
		List<Store> storeList = Reader.storeReader();
		for(Store store: storeList) {
			String managerCode = store.getManagerCode();
			for(Person person: personList) {
				String personCode = person.getPersonCode();
				if(managerCode.equals(personCode)) {
					store.setManager(person);
					System.out.println(store);
					break;
				}
			}
		}
		
		dataToJSON(saleItemList,personList,storeList);
	}
	
	public static void dataToJSON(List<SaleItem> saleItemList, List<Person> personList, List<Store> storeList) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String items = "items:";
		String person = "person:";
		String store = "store:";
		try {
			FileWriter itemsWrite = new FileWriter("data/SaleItems.json");
			FileWriter personWrite = new FileWriter("data/Person2.json");
			FileWriter storeWrite = new FileWriter("data/Store2.json");
			itemsWrite.write(items);
			itemsWrite.write(gson.toJson(saleItemList));
			personWrite.write(person);
			personWrite.write(gson.toJson(personList));
			storeWrite.write(store);
			storeWrite.write(gson.toJson(storeList));
			
			
			itemsWrite.close();
			personWrite.close();
			storeWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void dataToXML(List<SaleItem> saleItemList, List<Person> personList, List<Store> storeList) {
		
	}
}
