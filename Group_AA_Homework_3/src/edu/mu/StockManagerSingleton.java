package edu.mu;




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaproducts.*;


public class StockManagerSingleton {
	
	private final String inventoryFilePath = "files/inventory.csv";
	private ArrayList<MediaProduct> inventory;

	public StockManagerSingleton() {
		
	}
	
	public boolean initalizeStock() {
		boolean value = false;
		File inventoryFile = new File(inventoryFilePath);
		inventory = new ArrayList<>();
		try {
		Scanner scanner = new Scanner(inventoryFile);
		
		

		while(scanner.hasNext()) {
			value = true;
			String line = scanner.nextLine();
			String[] splitString = line.split(",", 5);
			if(splitString[0].equals("Type")) {
				
			}
			else {
			Double price = Double.parseDouble(splitString[2]);
			int year = Integer.parseInt(splitString[3]);
			String temp = splitString[4].toUpperCase();
			Genre genre = Genre.valueOf(temp);
			
			if(splitString[0].equals("CD")) {
				CDRecordProduct newProduct = new CDRecordProduct(splitString[1], price, year, genre);
				inventory.add(newProduct);
			}
			else if(splitString[0].equals("Vinyl")) {
				VinylRecordProduct newProduct = new VinylRecordProduct(splitString[1], price, year, genre);
				inventory.add(newProduct);
			}
			else if(splitString[0].equals("Tape")) {
				TapeRecordProduct newProduct = new TapeRecordProduct(splitString[1], price, year, genre);
				inventory.add(newProduct);
			}
			}
		}
		scanner.close();
		
		}
		catch (FileNotFoundException e){

            e.printStackTrace();
            value = false;
        }
		
		
		return value;
	}
	
	public void print() {
		for(MediaProduct product : inventory) {
			String info = product.toString();
			System.out.println(info);
		}
	
	}
	
	//Updates the price of the given media product to the newPrice.
	//Returns true if the update is successful, false otherwise
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		product.setPrice(newPrice); // sets the new price
		
		if(product.getPrice() == newPrice) //compares the price to the newPrice
			return true; //if they match is was successful
		
		else
			return false; //else return a failure
	}
	
	
	 //Adds a new media product to the inventory.
	 //Returns true if the addiHon is successful, false otherwise.
	public boolean addItem(MediaProduct product)
	{
		return true;
	}
		
	//Removes the given media product from the inventory.
	//Returns true if the removal is successful, false otherwise.
	public boolean removeItem(MediaProduct product)
	{
		return true;
	}
		



}
