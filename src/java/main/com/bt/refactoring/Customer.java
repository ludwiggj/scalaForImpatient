package com.bt.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		this.rentals.addElement(arg);
	}

	// Step08: Removed getName, as it is no longer called

	// Step08: Extracted methods from statement to
	//         make it easier to understand.
	public String statement() {
		return getStatementHeader()
				+ getRentalStatement()
				+ getStatementTotals();
	}

	// Step08: New method to generate statement header
	public String getStatementHeader() {
		return "Rental Record for " + name + "\n";
	}
	
	// Step08: New method to return statement of
	//         all rentals together with charges
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
	
	// Step08: New method to display statement totals
	public String getStatementTotals() {
		String result = "Amount owed is " + getTotalCharge() + "\n"
				+ "You earned " + getTotalFrequentRenterPoints()
				+ " frequent renter points";
		return result;
	}

	public double getTotalCharge() {
		double totalAmount = 0;

		Enumeration<Rental> enumeratedRentals = rentals.elements();

		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

	public int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;

		Enumeration<Rental> enumeratedRentals = rentals.elements();

		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
}