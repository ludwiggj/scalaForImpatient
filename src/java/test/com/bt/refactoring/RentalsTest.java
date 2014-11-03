package com.bt.refactoring;

import static org.junit.Assert.*;
import static com.bt.refactoring.Fixture.*;

import org.junit.Before;
import org.junit.Test;

// Step09: Relevant methods moved here from CustomerTest
public class RentalsTest {
	
	private Rentals rentals;
	
	@Before
	public void setUp() {
		rentals = new Rentals();
		
		rentals.add(RENTAL_REGULAR_ET_FOR_3_DAYS);
		rentals.add(RENTAL_CHILDRENS_DIVERGENT_FOR_2_DAYS);
		rentals.add(RENTAL_NEW_RELEASE_GONE_GIRL_FOR_5_DAYS);
	}
	
	@Test
	public void shouldGiveCorrectStatementForRentals() {
		String expectedStatement = "  ET  3.5\n"
				+ "  Divergent  1.5\n"
				+ "  Gone Girl  15.0\n";
		
		assertEquals(expectedStatement, rentals.getRentalStatement());
	}
	
	@Test
	public void shouldGiveCorrectTotalsForRentals() {
		String expectedStatement = "Amount owed is 20.0\n"
				+ "You earned 4 frequent renter points";
		
		assertEquals(expectedStatement, rentals.getRentalTotals());
	}	
}