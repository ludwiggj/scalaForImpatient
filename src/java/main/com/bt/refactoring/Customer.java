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
		Enumeration<Rental> enumeratedRentals = rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (enumeratedRentals.hasMoreElements()) {
			Rental rental = enumeratedRentals.nextElement();
        
			// show figures for this rental
			result += "  " + rental.getMovie().getTitle() + "  "
					+ String.valueOf(rental.getCharge()) + "\n";
		}

		// add footer lines
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints()
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

	// Step06: Code to calculate total frequent renter
	//         points extracted into a separate method
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