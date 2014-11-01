refactoringMovies (Step01)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step01**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

A good way to break down a large complicated method such as 
**Customer.statement()** is to [extract a chunk of code](http://sourcemaking.com/refactoring/extract-method) to a new method.

The resultant change will be for the better if the extracted code is relatively small and well-focused, and the new method is given a good name. It also gives us the opportunity to write more focused tests for the newly created method.

Thus in this step the code within **Customer.statement()**, which calculates the **charge** for a single **rental**, is extracted into a new method called **getCharge()**.

Your [IDE](http://en.wikipedia.org/wiki/Integrated_development_environment) will typically offer you a set number of refactoring options to assist which such changes. For example, I used the **Refactor > Extract Method** option offered by [Eclipse](https://www.eclipse.org/).

Three new tests have been added to **CustomerTest** to test the **getCharge()** method. Names of tests should carry meaning; you should be able to look at the implementation of the three tests below and not be surprised by what they are testing.

* **shouldChargeCorrectAmountForChildrensFilmTwoDayRental()**
* **shouldChargeCorrectAmountForRegularFilmThreeDayRental()**
* **shouldChargeCorrectAmountForNewReleaseFiveDayRental()**

Note that Eclipse made the newly extracted method **getCharge()** public, which is more permissive than it needs to be. I should have removed the **public** keyword, giving the method **package-private** visibility. This would allow the method to be called by the unit tests, but restrict its visibility so that the method cannot be called outside of the **com.bt.refactoring** package. See [Controlling Access to Members of a Class](http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) for more details.

Coming Next...
==============

**Step02**, in which we resolve a case of [feature envy](http://sourcemaking.com/refactoring/feature-envy) by moving the **getCharge()** method from **Customer** to **Rental**.

To get the code, check out the **Step02** tag e.g. from the git command line:

    git checkout Step02