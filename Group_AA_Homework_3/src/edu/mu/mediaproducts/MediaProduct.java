package edu.mu.mediaproducts;

import edu.mu.Genre;

public class MediaProduct {
	
	protected String title;
	protected Double price;
	protected int year;
	protected Genre genre;

	
	//default constructor
	public MediaProduct() {
		
	}
	
	
	//parameterized constructor
	public MediaProduct(String title, Double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	
	//copy constructor
	public MediaProduct(MediaProduct product) {
		this.title = product.title;
		this.price = product.price;
		this.year = product.year;
		this.genre = product.genre;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "MediaProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}
	
	
	
	
	
	

}
