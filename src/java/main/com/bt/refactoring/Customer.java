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

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		Enumeration<Rental> enumeratedRentals = rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (enumeratedRentals.hasMoreElements()) {
			double thisAmount = 0;

			Rental rental = enumeratedRentals.nextElement();
        
			thisAmount = rental.getCharge();
			
			// Step03: Moved code to calculate frequent renter points
			//         for a single rental into the Rental class
			frequentRenterPoints += rental.getFrequentRenterPoints();

			// show figures for this rental
			result += "  " + rental.getMovie().getTitle() + "  "
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";

		return result;
	}
}