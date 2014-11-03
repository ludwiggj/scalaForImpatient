package com.bt.refactoring;

public class Customer {

	private String name;
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
	
	private String getRentalStatement() {
		return rentals.getRentalStatement();
	}
	
	private String getRentalTotals() {
		return rentals.getRentalTotals();
	}
}