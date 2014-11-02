refactoringMovies (Step05)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step05**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

We now turn our attention to the loop in the **Customer.statement()** method. This code is more difficult to decipher that it should be, because:

* It suffers from the usual problem with Java loops; a lot of the code is concerned with the mechanics of iterating through the collection, rather than what is actually done with each element in the collection.

* More than one calculation is performed with each element of the collection.

This situation can be improved by extracting a method, in this case one that calculates the total charge for a **customer**.

Coming Next...
==============

**Step06**, in which we extract another method from **Customer.statement()** to calculate the total rental points for a customer.

To get the code, check out the **Step06** tag e.g. from the git command line:

    git checkout Step06