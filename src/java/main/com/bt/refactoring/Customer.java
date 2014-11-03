package com.bt.refactoring;

public class Customer {

	private String name;
	
	// Step09: Vector of rentals now replaced with Rentals type
	//         All methods operating on the vector have been
	//         moved to the Rentals type.
	private Rentals rentals = new Rentals();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		return getStatementHeader()
				+ getRentalStatement()
				+ getRentalTotals();
	}

	private String getStatementHeader() {
		return "Rental Record for " + name + "\n";
	}
	
	// Step09: Call now delegated through to Rentals type.
	//         This method is now private.
	private String getRentalStatement() {
		return rentals.getRentalStatement();
	}
	
	// Step09: Call now delegated through to Rentals type
	//  This method is now private.
	private String getRentalTotals() {
		return rentals.getRentalTotals();
	}
}