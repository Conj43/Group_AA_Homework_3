package edu.mu.mediaproducts;

import edu.mu.Genre;

public class VinylRecordProduct extends MediaProduct{

	
	


	//default constructor
	public VinylRecordProduct() {
	}
	
	
	//super constructor
	public VinylRecordProduct(String title, Double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	//copy constructor
		public VinylRecordProduct(VinylRecordProduct product) {
			this.title = product.title;
			this.price = product.price;
			this.year = product.year;
			this.genre = product.genre;
		}
		
		
		@Override
		public String toString() {
			return "VinylRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
		}

}
