package edu.mu;

import java.util.ArrayList;

import edu.mu.mediaproducts.*;

public class Main {

	

	public static void main(String[] args) {
		StockManagerSingleton stockManager = new StockManagerSingleton();
		
		stockManager.initalizeStock();
		
		stockManager.print(stockManager.inventory);
		
		System.out.println("CDs:\n");
		
		ArrayList<CDRecordProduct> cdList = stockManager.getCDRecordsList(stockManager.inventory);
		
		stockManager.print(cdList);
		
		System.out.println("Tapes:\n");
		
		ArrayList<TapeRecordProduct> tapeList = stockManager.getTapeRecordsList(stockManager.inventory);
		
		stockManager.print(tapeList);
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		

	}

}
