refactoringMovies (Step11)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step11**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

Imagine that we want to support a new category of **movie** e.g. science fiction. Consider what would need to change in the **Movie** class, if we stayed with its current implementation: 

    public class Movie {
        public static final int REGULAR = 0;
        public static final int NEW_RELEASE = 1;
        public static final int CHILDRENS = 2;
        
        ////////////////////////////////////////////////////////////////////////
        // (1) A new integer constant to represent the science fiction category
        ////////////////////////////////////////////////////////////////////////
        public static final int SCIENCE_FICTION = 3;

        private String title;
        private int priceCode;

        public Movie(String title, int priceCode) {
            this.title = title;
            this.priceCode = priceCode;
        }

        ...

        public double getCharge(int daysRented) {
            double thisAmount = 0;

            switch (priceCode) {
                case Movie.REGULAR:
                  ...
                break;
                
                  ...
                  
                case Movie.CHILDRENS:
                  ...
                break;
                
                ////////////////////////////////////////////////////////////////////////////////
                // (2) A new case statement to calculate the charge for a science fiction film.
                ////////////////////////////////////////////////////////////////////////////////
                
                case Movie.SCIENCE_FICTION:
                  ...
                break;
            }
            return thisAmount;
        }
	
        public int getFrequentRenterPoints(int daysRented) {
            /////////////////////////////////////////////////////////////////////
            // (3) We may need to adjust this code depending on how the frequent
            //     renter points are calculated for a science fiction film.
            /////////////////////////////////////////////////////////////////////
            if ((priceCode == Movie.NEW_RELEASE) && daysRented > 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }

The key thing to note is that we would disturb existing code that is already working for existing movie categories (regular, children's etc.) in order to introduce logic for a new film category. This violates the [open-closed principle](http://en.wikipedia.org/wiki/Open/closed_principle#Polymorphic_open.2Fclosed_principle).

This leads us to extract an enum called **MovieCategory** from **Movie**, to represent the category of the movie; initially **regular**, **new release** and **children's**.

The **MovieCategory** enum defines two methods:

* **getCharge()**, to calculate the charge for the movie. This method is abstract, which means that every instance of the enum must provide an implementation.

* **getFrequentRenterPoints()**, to calculate the frequent renter points. This has a default implementation, as it is the same in most cases. If the calculation differs for a specific movie category then it can be overriden, as it is for **new releases**.

This implementation has the following advantages:

* It follows the [open-closed principle](http://en.wikipedia.org/wiki/Open/closed_principle#Polymorphic_open.2Fclosed_principle). To add the **science fiction** movie category, we would simply add a new value **SCIENCE_FICTION** to **MovieCategory**, provide an implementation of **getCharge()** and override the default implementation of **getFrequentRenterPoints()** if needed. Note that the implementation of the existing movie categories would be unaffected by adding the new science fiction category. This is what is meant by **MovieCategory** being open for extension, but closed for modification. Compare this situation with adding the science fiction category to the **Movie** class, as described above.

* **MovieCategory** is a stronger type to use than representing the movie's price code via an integer.


Coming Next...
==============

That's it!

You might want to go back to the original code:

    git checkout Start
    
and consider how the code has changed during the refactoring process. The code behaves the same way (as evidenced by the original test, **CustomerTest.shouldGiveCorrectStatementForCustomerWithRentals()**, which still passes), but it better designed, more flexible, easier to understand, and covered by better tests.