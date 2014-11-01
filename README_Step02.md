refactoringMovies (Step02)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step02**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The **Customer.getCharge()** method is a classic case of [feature envy](http://sourcemaking.com/refactoring/feature-envy). This is defined as follows:

    A classic smell is a method that seems more interested in a class other than the one it actually is in. 

The **getCharge** method calls several methods on the rental instance passed into it, and also makes no use of the data in the customer class. Thus the method should clearly be moved to the **Rental** class.

We also create a new test class **RentalTest** and move the getCharge tests into it from **CustomerTest**.

Finally, we note that now **getCharge()** is a method of **Rental**, it no longer needs to call the **getDaysRented()** and **getMovie()** methods; they can be inlined, and the data members **daysRented** and **movie** used directly.

Coming Next...
==============

**Step03**, in which we...

To get the code, check out the **Step03** tag e.g. from the git command line:

    git checkout Step03