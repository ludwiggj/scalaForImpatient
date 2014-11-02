refactoringMovies (Step06)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step06**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

In step 5 we extracted a method **getTotalCharge()** from the main loop in the **Customer.statement()** method.

We now finish the process in this step, extracting a method **getTotalFrequentRenterPoints()** to calculate the total rental points for a customer.

If we consider the effect of extracting the **getTotalCharge()** and **getTotalFrequentRenterPoints()** methods from the **Customer.statement()** method:

* We now have more code; but that's OK, as the code is easier for humans to read and understand.

* The code will execute more slowly, since it will iterate the collection of rentals twice to calculate the total charge and total frequent renter points, rather than once. However, the clarity of the code is more important at this stage; we should not optimise the code prematurely(http://c2.com/cgi/wiki?PrematureOptimization).

Coming Next...
==============

**Step07**, in which we realise that the **Rental.getCharge()** method really belongs in the **Movie** class.

To get the code, check out the **Step07** tag e.g. from the git command line:

    git checkout Step07