refactoringMovies (Step08)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step08**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The **Customer.statement()** method is much easier to understand than previously, but we can still do better. In this step we extract three new methods, **getStatementHeader()**, **getRentalStatement()** and **getStatementTotals()**, so that **Customer.statement()** is now straightforward.

The **Customer.getName()** method is also removed as it is no longer needed.

Coming Next...
==============

**Step09**, in which we extract a new class **Rentals** from **Customer** to represent one or more rentals.

To get the code, check out the **Step09** tag e.g. from the git command line:

    git checkout Step09