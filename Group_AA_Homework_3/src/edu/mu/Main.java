package edu.mu;

import java.util.ArrayList;

import edu.mu.mediaproducts.*;

public class Main {
	private static boolean test = false;
	
	public static void print() {
		
		System.out.println("\nTest: " + test + "\n");
	}

	

	public static void main(String[] args) {
		
		
		StockManagerSingleton stockManager = new StockManagerSingleton();
		
		test = stockManager.initalizeStock();
		
		System.out.println("First Print:\n");
		
		print();
		
		stockManager.printListOfMediaProduct(stockManager.inventory);
		
		System.out.println("\nCDs:\n");
		
		ArrayList<CDRecordProduct> cdList = stockManager.getCDRecordsList(stockManager.inventory);
		
		stockManager.print(cdList);
		
		System.out.println("\nTapes:\n");
		
		ArrayList<TapeRecordProduct> tapeList = stockManager.getTapeRecordsList(stockManager.inventory);
		
		stockManager.print(tapeList);
		
		System.out.println("\nVinyls:\n");
		
		ArrayList<VinylRecordProduct> vinylList = stockManager.getVinylRecordList(stockManager.inventory);
		
		stockManager.print(vinylList);
		
		System.out.println("\nChanging first Item's price...\n");
		
		MediaProduct product = stockManager.inventory.get(0);
		
		test = stockManager.updateItemPrice(product, 20.50);
		
		print();
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		
		test = stockManager.removeItem(stockManager.inventory.get(1));
		
		System.out.println("\nRemoving the second Item...\n");
		
		print();
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		
		System.out.println("\nAdding a new Product at the end of the list...\n");
		
		Genre genre = Genre.valueOf("HIP_HOP");
		
		CDRecordProduct newProduct = new CDRecordProduct("New Item", 9.99, 2009, genre);
		
		test = stockManager.addItem(newProduct);
		
		print();
		
		System.out.println("Reprint Inventory:\n");
		
		stockManager.print(stockManager.inventory);
		
		ArrayList<MediaProduct> belowPriceList = new ArrayList<>();
		
		belowPriceList = stockManager.getMediaProductBelowPrice(20);
		
		System.out.println("\nMedia Products Under $20:\n");
		
		stockManager.print(belowPriceList);
		
		
		
		test = stockManager.saveStock();
		
		print();

	}

}
