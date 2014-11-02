package com.bt.refactoring;

import static org.junit.Assert.*;
import static com.bt.refactoring.Fixture.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private final double ERROR_DELTA = 0.1;
	
	private Customer customer;
	
	@Before
	public void setUp() {
		customer = new Customer("Graeme");
		
		customer.addRental(RENTAL_REGULAR_ET_FOR_3_DAYS);
		customer.addRental(RENTAL_CHILDRENS_DIVERGENT_FOR_2_DAYS);
		customer.addRental(RENTAL_NEW_RELEASE_GONE_GIRL_FOR_5_DAYS);
	}
	
	@Test
	public void shouldGiveCorrectStatementForCustomerWithRentals() {
		String expectedStatement = "Rental Record for Graeme\n"
				+ "  ET  3.5\n"
				+ "  Divergent  1.5\n"
				+ "  Gone Girl  15.0\n"
				+ "Amount owed is 20.0\n"
				+ "You earned 4 frequent renter points";
		
		assertEquals(expectedStatement, customer.statement());
	}
	
	// Step05: Test for newly extracted method to calculate
	//         total charge for all rentals
	@Test
	public void shouldCalculateTotalChargeForCustomerWithRentals() {
		assertEquals(20.0, customer.getTotalCharge(), ERROR_DELTA);
	}
}