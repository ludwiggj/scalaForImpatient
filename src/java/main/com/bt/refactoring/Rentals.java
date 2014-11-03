package com.bt.refactoring;

import java.util.Enumeration;
import java.util.Vector;

// Step09: New type to represent Rentals
public class Rentals {

	private Vector<Rental> rentals = new Vector<>();

	public void add(Rental rental) {
		this.rentals.addElement(rental);
	}
	
	public String getRentalStatement() {
		String result = "";

		Enumeration<Rental> enumeratedRentals = rentals.elements();
		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();

			// show figures for this rental
			result += "  " + rental.getMovie().getTitle() + "  "
					+ String.valueOf(rental.getCharge()) + "\n";
		}
		return result;
	}

	public String getRentalTotals() {
		return "Amount owed is " + getTotalCharge() + "\n"
				+ "You earned " + getTotalFrequentRenterPoints()
				+ " frequent renter points";
	}
	
	// Step09: Method is private as it is only used to generate
	//         rental totals statement
	private double getTotalCharge() {
		double totalAmount = 0;

		Enumeration<Rental> enumeratedRentals = rentals.elements();

		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

	// Step09: Method is private as it is only used to generate
	//         rental totals statement
	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;

		Enumeration<Rental> enumeratedRentals = rentals.elements();

		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}