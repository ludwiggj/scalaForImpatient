refactoringMovies (Step03)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step03**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The code that calculates the frequent renter points for a single rental is extracted from **Customer** into a new method on **Rental**, **Rental.getFrequentRenterPoints()**. This was another case of [feature envy](http://sourcemaking.com/refactoring/feature-envy).

We added some more tests to **RentalTest** to test the new method **Rental.getFrequentRenterPoints()** directly.

Coming Next...
==============

**Step04**, in which...

To get the code, check out the **Step04** tag e.g. from the git command line:

    git checkout Step04