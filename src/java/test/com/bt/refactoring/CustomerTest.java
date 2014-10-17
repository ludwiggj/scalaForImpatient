package com.bt.refactoring;

import static org.junit.Assert.*;
import static com.bt.refactoring.Fixture.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;
	
	
	@Before
	public void setUp() {
		customer = new Customer("Graeme");
	}

	@Test
	public void testForCustomerWithNoRentals() {
		String expectedStatement = "Rental Record for Graeme\n"
				+ "Amount owed is 0.0\n"
				+ "You earned 0 frequent renter points";
		
		assertEquals(expectedStatement, customer.statement());
	}
	
	@Test
	public void testForCustomerWithSeveralRentals() {
		customer.addRental(RENTAL_REGULAR_ET);
		customer.addRental(RENTAL_CHILDRENS_DIVERGENT);
		customer.addRental(RENTAL_NEW_RELEASE_GONE_GIRL);
		
		String expectedStatement = "Rental Record for Graeme\n"
				+ "  ET  3.5\n"
				+ "  Divergent  1.5\n"
				+ "  Gone Girl  15.0\n"
				+ "Amount owed is 20.0\n"
				+ "You earned 4 frequent renter points";
		
		assertEquals(expectedStatement, customer.statement());
	}
}