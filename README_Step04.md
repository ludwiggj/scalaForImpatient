refactoringMovies (Step04)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step04**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The method **Rental.getDaysRented()** is deleted since it is no longer used.

We also simplify the implementation of the **Rental.getFrequentRenterPoints()** method. No tests are added, but we can again rely on the existing tests to guard against any bugs creeping in to our code.

Coming Next...
==============

**Step05**, in which we extract a method from **Customer.statement()** to calculate the total charge for a customer.

To get the code, check out the **Step05** tag e.g. from the git command line:

    git checkout Step05