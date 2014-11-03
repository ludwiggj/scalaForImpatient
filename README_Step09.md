refactoringMovies (Step09)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step09**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

We realise that some of the methods in **Customer** deal exclusively with the collection of **rentals**. Thus it makes sense to extract these into a separate class, **Rentals**, which represents the rentals the customer has made.

Extracting the **Rentals** class is a good idea for several reasons:

* The **Rentals** type is more meaningful than **Vector**. Modern IDEs can take advantage of more specific types to guide and assist the developer.

* The **Vector** class exposes multiple methods, many of which are not needed. We take more control by wrapping the **Vector** class up in the **Rentals** class, only exposing the desired methods of **Vector** through the **Rentals** interface.

* Since **Vector** is private to **Rentals**, we can replace the **Vector** with an alternative implementation in the future if needed, without changing the public API of **Rentals**.

* The **Rentals** type is a [seam](http://c2.com/cgi/wiki?SoftwareSeam) which can be mocked to assist with testing.

We also move the tests **shouldCalculateTotalChargeForCustomerWithRentals()** and **shouldCalculateTotalFrequentRenterPointsForCustomerWithRentals()** from **CustomerTest** to a newly created test class, **RentalsTest**.

The **Rentals.getTotalCharge()** and **Rentals.getTotalFrequentRenterPoints()** methods are made private, since they are only used by the **Rentals.getRentalTotals()** method.

Thus the tests **shouldCalculateTotalChargeForCustomerWithRentals()** and **shouldCalculateTotalFrequentRenterPointsForCustomerWithRentals()** in **RentalsTest** are reworked into a new test **shouldGiveCorrectTotalsForRentals()**, which tests the **Rentals.getRentalTotals()** method directly.

We note now that there is a certain amount of overlap between the tests in **CustomerTest** and **RentalsTest**, which we should consider addressing.

Coming Next...
==============

**Step10**, in which we simplify the **Rentals** class by changing the way the rentals are iterated, and removing another case of [feature envy](http://sourcemaking.com/refactoring/feature-envy).

To get the code, check out the **Step10** tag e.g. from the git command line:

    git checkout Step10