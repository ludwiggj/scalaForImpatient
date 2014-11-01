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

			Rental each = enumeratedRentals.nextElement();

			// STEP_01: Just call the extracted method getCharge()
			//          to calculate the charge for a single rental
			thisAmount = getCharge(each);

			// add frequent renter points
			frequentRenterPoints++;

			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "  " + each.getMovie().getTitle() + "  "
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";

		return result;
	}

	// STEP_01: Method extracted from statement method to
	//          calculate the charge for a single rental
	public double getCharge(Rental each) {
		double thisAmount = 0;

		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;

		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;

		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;

		}
		return thisAmount;
	}
}