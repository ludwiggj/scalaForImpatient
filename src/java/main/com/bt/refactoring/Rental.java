package com.bt.refactoring;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	// Step10: Removed getMovie() method

	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
	
	// Step10: Method to display rental details
	@Override
	public String toString() {
		return movie.getTitle() + "  " + getCharge();
	}
}