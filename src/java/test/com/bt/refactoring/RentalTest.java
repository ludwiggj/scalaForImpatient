package com.bt.refactoring;

import static org.junit.Assert.*;
import static com.bt.refactoring.Fixture.*;
import org.junit.Test;

public class RentalTest {
	private final double ERROR_DELTA = 0.1;
	
	@Test
	public void shouldChargeCorrectAmountForChildrensFilmTwoDayRental() {
		assertEquals(1.5, RENTAL_CHILDRENS_DIVERGENT_FOR_2_DAYS.getCharge(), ERROR_DELTA);
	}

	@Test
	public void shouldChargeCorrectAmountForRegularFilmThreeDayRental() {
		assertEquals(3.5, RENTAL_REGULAR_ET_FOR_3_DAYS.getCharge(), ERROR_DELTA);
	}

	@Test
	public void shouldChargeCorrectAmountForNewReleaseFiveDayRental() {
		assertEquals(15.0, RENTAL_NEW_RELEASE_GONE_GIRL_FOR_5_DAYS.getCharge(), ERROR_DELTA);
	}
	
	// Step03: New tests for Rental.getFrequentRenterPoints() method
	@Test
	public void shouldGetOneFrequentRenterPointWhenRentANewReleaseForOneDay() {
		assertEquals(1, new Rental(MOVIE_NEW_RELEASE_GONE_GIRL, 1).getFrequentRenterPoints());
	}

	@Test
	public void shouldGetTwoFrequentRenterPointsWhenRentANewReleaseForTwoDays() {
		assertEquals(2, new Rental(MOVIE_NEW_RELEASE_GONE_GIRL, 2).getFrequentRenterPoints());
	}

	@Test
	public void shouldGetTwoFrequentRenterPointsWhenRentANewReleaseForFiveDays() {
		assertEquals(2, new Rental(MOVIE_NEW_RELEASE_GONE_GIRL, 5).getFrequentRenterPoints());
	}
}