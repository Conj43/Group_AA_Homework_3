package edu.mu.mediaproducts;

import edu.mu.Genre;

public class TapeRecordProduct extends MediaProduct{

	//default constructor
		public TapeRecordProduct() {
		}
		
		
		//super constructor
		public TapeRecordProduct(String title, Double price, int year, Genre genre) {
			super(title, price, year, genre);
		}
		
		//copy constructor
			public TapeRecordProduct(TapeRecordProduct product) {
				this.title = product.title;
				this.price = product.price;
				this.year = product.year;
				this.genre = product.genre;
			}


			@Override
			public String toString() {
				return "TapeRecordProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre
						+ "]";
			}

}
