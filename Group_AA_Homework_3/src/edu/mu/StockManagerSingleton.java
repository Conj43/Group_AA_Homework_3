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
	
	//saves the updated inventory back to the CSV file
	public boolean saveStock() {
	    try (FileWriter writer = new FileWriter(inventoryFilePath)) { //opens a filewriter to write data to the file
	        for (MediaProduct product : inventory) {
	            writer.write(product.getTitle() + "," + product.getPrice() + "," + product.getYear() + "," + product.getGenre() + "\n");
	        }
	        return true;
	    } catch (IOException e) { //exception handle
	        e.printStackTrace();
	        return false;
	    }
	}
//gets the media producsw that are under the max price. 
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
	    ArrayList<MediaProduct> belowPriceList = new ArrayList<>(); //makes na array list to store the products below the max price
	    for (MediaProduct product : inventory) {
	        if (product.getPrice() < maxPrice) {
	            belowPriceList.add(new MediaProduct(product)); 
	        }
	    }
	    return belowPriceList;
	}

}



}
