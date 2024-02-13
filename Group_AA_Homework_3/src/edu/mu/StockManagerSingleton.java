package edu.mu;




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaproducts.*;


public class StockManagerSingleton {
	
	private final String inventoryFilePath = "files/inventory.csv"; //create path to csv file; use final keyword so it cannot be changed
	public ArrayList<MediaProduct> inventory; //create inventory so we can access it in our main class
	
	
	//default constructor
	public StockManagerSingleton() {
		
	}
	
	//method that reads csv file at inventoryFilePath and puts it into an arraylist of type MediaProduct called inventory
	//returns true on success, false on failure
	public boolean initalizeStock() {
		boolean value = false; //initalize return value
		File inventoryFile = new File(inventoryFilePath); //creating file pointing to file path
		inventory = new ArrayList<>();
		try {
		Scanner scanner = new Scanner(inventoryFile); //create scanner for csv file
		

		while(scanner.hasNext()) { //loop to end of file
			value = true; //if scanner works, and file isn't empty, we set return value to true
			String line = scanner.nextLine();   //create one big string as the next line
			String[] splitString = line.split(",", 5); //due to csv file format, we can split at each comma
			if(splitString[0].equals("Type")) { //checks if we are looking at the first row, which is just name of each column
				//if true, we don't want to add this to our array list so we do nothing
			}
			else {
			Double price = Double.parseDouble(splitString[2]); //the third element of string is the price, we need to convert from string to double
			int year = Integer.parseInt(splitString[3]); //fourth element of string is the year, we convert from string to integer
			String temp = splitString[4].toUpperCase(); //fifth element is the genre, and we convert to upper so we can properly find the ENUM value
			Genre genre = Genre.valueOf(temp); //use upper case string to find corresponding genre
			
			
			//here we are looking to see which type of media product we need to create
			//since each class is subclass of MediaProduct we can create a big array list of type media product and add each product to it to keep track of inventory
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
		scanner.close(); //close scanner
		
		}
		catch (FileNotFoundException e){

            e.printStackTrace();
            value = false; //change return value to false if we couldn't find file or something went wrong
        }
		
		
		return value;//return true on success, false on failure
	}
	
	
	//we use generic type T of MediaProduct so we can use this function to print out every element of an array list of any type we have created
	public <T extends MediaProduct> void print(ArrayList<T> products) {
		int i = 1;
		for(MediaProduct product : products) {
			String info = product.toString(); //very easy because we use toString method that we implemented in each class
			System.out.println(i + ") " + info);  //use a counter to see how many products are in the list
			i++;
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
		inventory.add(product); //adds the new product to the array list inventory
		
		if(inventory.contains(product) == true) //checks to see if inventory contains the new item
				return true;                  
			//returns success
		else
			return false; //else returns failure
	}
		
	//Removes the given media product from the inventory.
	//Returns true if the removal is successful, false otherwise.
	public boolean removeItem(MediaProduct product)
	{
		inventory.remove(product); //removes the product from inventory
		
		if(inventory.contains(product) == false) //checks to see if the array list contains product
			return true; //returns success
		else
			return false; //else return failure
	}
		//saves the updated inventory back to the CSV file
	public boolean saveStock() {
	    try (FileWriter writer = new FileWriter(inventoryFilePath)) { //opens a filewriter to write data to the file
	        for (MediaProduct product : inventory) 
          {    
              writer.write(product.getTitle() + "," + product.getPrice() + "," + product.getYear() + "," + product.getGenre() + "\n");
	        }
	        return true;
	    } catch (IOException e) //exception handle
      { 
          e.printStackTrace();
	        return false;
	    }
	}
//gets the media products that are under the max price. 
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) 
    {
	    ArrayList<MediaProduct> belowPriceList = new ArrayList<>(); //makes na array list to store the products below the max price
	    for (MediaProduct product : inventory) 
      {
	        if (product.getPrice() < maxPrice) 
          {
	            belowPriceList.add(new MediaProduct(product)); 
	        }
	    }
	    return belowPriceList;
	}	
	
  
  
  //kymani's code here
  
  
  //this method takes an array list of type media product and returns an array list of type cd record product with each cd type in the inventory
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		
		ArrayList<CDRecordProduct> cdList = new ArrayList<>(); //create new array list
		
		for(MediaProduct currentProduct : productList) { //loop through entire product list
			if(currentProduct instanceof CDRecordProduct) { //if current product is a CD, add it to the list
				CDRecordProduct newCD = new CDRecordProduct((CDRecordProduct) currentProduct); //we use the copy constructor so that we don't leak info
				cdList.add(newCD); //add it to the new array list
			}
		}
		return cdList; //return new cd array list
		
	}
	
	//this method takes an array list of type media product and creates an array list of type tape product and returns that array list with each tape in the inventory
	public ArrayList<TapeRecordProduct> getTapeRecordsList(ArrayList<MediaProduct> productList){
		
		ArrayList<TapeRecordProduct> tapeList = new ArrayList<>();
		
		for(MediaProduct currentProduct : productList) {
			if(currentProduct instanceof TapeRecordProduct) {
				TapeRecordProduct newTape = new TapeRecordProduct((TapeRecordProduct) currentProduct); //use copy constructor so we don't leak info
				tapeList.add(newTape);
			}
		}
		return tapeList; //return new tape array list
		
	}

}
