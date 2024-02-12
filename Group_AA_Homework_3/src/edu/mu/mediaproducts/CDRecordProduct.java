package edu.mu.mediaproducts;

import edu.mu.Genre;

public class CDRecordProduct extends MediaProduct{

	//default constructor
		public CDRecordProduct() {
		}
		
		
		//super constructor
		public CDRecordProduct(String title, Double price, int year, Genre genre) {
			super(title, price, year, genre);
		}
		
		//copy constructor
			public CDRecordProduct(CDRecordProduct product) {
				this.title = product.title;
				this.price = product.price;
				this.year = product.year;
				this.genre = product.genre;
			}


			@Override
			public String toString() {
				return "CDRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre
						+ "]";
			}
			
			
			

}
