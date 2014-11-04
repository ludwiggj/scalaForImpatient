package com.bt.refactoring;

public class Fixture {
	public static final Movie MOVIE_CHILDRENS_DIVERGENT = new Movie("Divergent", MovieCategory.CHILDRENS);
	public static final Movie MOVIE_NEW_RELEASE_GONE_GIRL = new Movie("Gone Girl", MovieCategory.NEW_RELEASE);
	public static final Movie MOVIE_NEW_RELEASE_MAZE_RUNNER = new Movie("The Maze Runner", MovieCategory.NEW_RELEASE);
	public static final Movie MOVIE_REGULAR_ET = new Movie("ET", MovieCategory.REGULAR);
	
	public static final Rental RENTAL_REGULAR_ET_FOR_3_DAYS = new Rental(MOVIE_REGULAR_ET, 3);
	public static final Rental RENTAL_CHILDRENS_DIVERGENT_FOR_2_DAYS = new Rental(MOVIE_CHILDRENS_DIVERGENT, 2);
	public static final Rental RENTAL_NEW_RELEASE_GONE_GIRL_FOR_5_DAYS = new Rental(MOVIE_NEW_RELEASE_GONE_GIRL, 5);
	
	private Fixture() {	
	}
}