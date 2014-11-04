package com.bt.refactoring;

public class Movie {
	private String title;
	
	// Step11: Replaced integer priceCode with movie category
	private MovieCategory category;

	public Movie(String title, MovieCategory movieCategory) {
		this.title = title;
		this.category = movieCategory;
	}

	// Step11: Removed getPriceCode() && setPriceCode()

	public String getTitle() {
		return title;
	}

	// Step11: Delegate call to movie category
	public double getCharge(int daysRented) {
		return category.getCharge(daysRented);
	}
	
	// Step11: Delegate call to movie category
	public int getFrequentRenterPoints(int daysRented) {
		return category.getFrequentRenterPoints(daysRented);
	}
}