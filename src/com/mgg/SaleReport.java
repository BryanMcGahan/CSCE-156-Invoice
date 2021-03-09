package com.mgg;

import java.util.List;


public class SaleReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Sale> saleList = Reader.saleReader();
		salesPersonReport(saleList);

	}
	
	public static void salesPersonReport(List<Sale> saleList) {
		
		for(Sale sale: saleList) {
			List<SaleItem> saleItemList = sale.getSaleItemList();
			for(SaleItem item: saleItemList) {
				System.out.println(item.getSaleItemName()+ " " + item.calcTotalPrice());
			}
		}
		
		
	}

}
