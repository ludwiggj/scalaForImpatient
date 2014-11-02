package com.bt.refactoring;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	// Step07: Now delegate call to movie.getCharge()
	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	// Step07: Now delegate call to movie.getFrequentRenterPoints()
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
}