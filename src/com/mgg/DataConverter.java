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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * This class is our main driver to the project, it takes our newly created
 * objects from *Reader.java and writes them JSON and XML files for data
 * storage.
 * 
 * @author bryanmcgahan
 *
 */
public class DataConverter {

	public static void main(String[] args) {

		List<SaleItem> saleItemList = Reader.itemsReader();
		List<Person> personList = Reader.personReader();
		List<Store> storeList = Reader.storeReader();
		
		/*
		 * Looping through the list of stores and matching manager codes to person codes
		 * and setting the matching person to the matching stores manager. 
		 */

		dataToJSON(saleItemList, personList, storeList);
		dataToXML(saleItemList, personList, storeList);
	}

	public static void dataToJSON(List<SaleItem> saleItemList, List<Person> personList, List<Store> storeList) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String items = "items:";
		String person = "person:";
		String store = "store:";
		try {

			FileWriter itemsWrite = new FileWriter("data/Items.json");
			FileWriter personWrite = new FileWriter("data/Persons.json");
			FileWriter storeWrite = new FileWriter("data/Stores.json");

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
			e.printStackTrace();
		}

	}

	public static void dataToXML(List<SaleItem> saleItemList, List<Person> personList, List<Store> storeList) {

		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);

		try {
			FileWriter itemsWriter = new FileWriter("data/Items.xml");
			FileWriter personsWriter = new FileWriter("data/Persons.xml");
			FileWriter storeWriter = new FileWriter("data/Stores.xml");

			xstream.processAnnotations(Store.class);
			xstream.alias("Stores", List.class);
			xstream.toXML(storeList, storeWriter);
			storeWriter.close();

			xstream.processAnnotations(Person.class);
			xstream.alias("persons", List.class);
			xstream.toXML(personList, personsWriter);
			personsWriter.close();

			xstream.alias("items", List.class);
			xstream.processAnnotations(SaleItem.class);
			xstream.processAnnotations(Service.class);
			xstream.processAnnotations(Subscription.class);
			xstream.processAnnotations(NewProduct.class);
			xstream.processAnnotations(UsedProduct.class);
			xstream.processAnnotations(GiftCard.class);
			xstream.toXML(saleItemList, itemsWriter);
			itemsWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
