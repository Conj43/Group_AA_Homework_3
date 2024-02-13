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
		
		
		
		System.out.println("Change Item Price:\n");
		
		MediaProduct product = stockManager.inventory.get(0);
		
		stockManager.updateItemPrice(product, 15.99);
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		
		stockManager.removeItem(stockManager.inventory.get(1));
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		
		Genre genre = Genre.valueOf("HIP_HOP");
		
		CDRecordProduct newProduct = new CDRecordProduct("New Item", 9.99, 2009, genre);
		
		stockManager.addItem(newProduct);
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);

	}

}
