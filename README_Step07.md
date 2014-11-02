refactoringMovies (Step07)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step07**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The **Rental.getCharge()** method depends on both the movie's **price code**, and the **number of days** the movie has been rented.

It might seem reasonable that the method is in the **rental** class, since the rental class knows how long the movie has been rented for.

However, the **key thing** to note is that the algorithm used to calculate the charge depends upon the movie's **price code**. Each algorithm requires the **number of days rented**, but the number of days rented is really an input to the algorithm.

Hence, as the algorithm depends primarily on the **price code**, it makes sense to relocate it to the **movie** class, and supply the **number of days rented** as an argument.

A similar argument leads to the relocation of the **Rental.getFrequentRenterPoints()** method  to the **movie** class.

Coming Next...
==============

**Step08**, in which we extract some more methods from **Customer.statement()** to make it easier to understand.

To get the code, check out the **Step08** tag e.g. from the git command line:

    git checkout Step08