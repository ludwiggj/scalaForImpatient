package com.bt.refactoring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private static final Movie MOVIE_HUNGER_GAMES = new Movie("The Hunger Games", Movie.CHILDRENS);
	private static final Movie MOVIE_DIVERGENT = new Movie("Divergent", Movie.CHILDRENS);
	private static final Movie MOVIE_MAZE_RUNNER = new Movie("The Maze Runner", Movie.NEW_RELEASE);
	private static final Movie MOVIE_GONE_GIRL = new Movie("Gone Girl", Movie.CHILDRENS);
	private static final Movie MOVIE_EXPENDABLES = new Movie("The Expendables 47", Movie.REGULAR);
	private static final Movie MOVIE_ET = new Movie("ET", Movie.REGULAR);

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
		customer.addRental(new Rental(MOVIE_ET, 3));
		customer.addRental(new Rental(MOVIE_DIVERGENT, 2));
		customer.addRental(new Rental(MOVIE_GONE_GIRL, 5));
		
		String expectedStatement = "Rental Record for Graeme\n"
				+ "  ET  3.5\n"
				+ "  Divergent  1.5\n"
				+ "  Gone Girl  4.5\n"
				+ "Amount owed is 9.5\n"
				+ "You earned 3 frequent renter points";
		
		assertEquals(expectedStatement, customer.statement());
	}
}