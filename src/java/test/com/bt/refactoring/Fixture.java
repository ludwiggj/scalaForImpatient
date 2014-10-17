package com.bt.refactoring;

public class Fixture {
	public static final Movie MOVIE_CHILDRENS_DIVERGENT = new Movie("Divergent", Movie.CHILDRENS);
	public static final Movie MOVIE_NEW_RELEASE_GONE_GIRL = new Movie("Gone Girl", Movie.NEW_RELEASE);
	public static final Movie MOVIE_NEW_RELEASE_MAZE_RUNNER = new Movie("The Maze Runner", Movie.NEW_RELEASE);
	public static final Movie MOVIE_REGULAR_ET = new Movie("ET", Movie.REGULAR);
	
	public static final Rental RENTAL_REGULAR_ET = new Rental(MOVIE_REGULAR_ET, 3);
	public static final Rental RENTAL_CHILDRENS_DIVERGENT = new Rental(MOVIE_CHILDRENS_DIVERGENT, 2);
	public static final Rental RENTAL_NEW_RELEASE_GONE_GIRL = new Rental(MOVIE_NEW_RELEASE_GONE_GIRL, 5);
	
	private Fixture() {	
	}
}