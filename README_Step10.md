refactoringMovies (Step10)
==========================

# Code Changes

All code changes made in this step have been commented with the
word **Step10**. Thus you can easily identify the changes by searching the code within your IDE, or [diffing the code using git](http://stackoverflow.com/questions/1552340/show-all-changed-files-between-two-git-commits).

# Description

The rentals vector is iterated in the **Rentals** class using an enumeration. However, if you know that you are going to visit every member of the collection (as in these cases) it is much simpler to use the for construct.

Also, the code to display the details of a single rental is extracted out to the **Rental.toString()** method, since this code was a case of [feature envy](http://sourcemaking.com/refactoring/feature-envy).

Coming Next...
==============

**Step11**, in which we consider what changes we might need to introduce to the code to support a new type of **movie** e.g. science fiction. Consideration of this new requirement, and of the [open-closed principle](http://en.wikipedia.org/wiki/Open/closed_principle#Polymorphic_open.2Fclosed_principle) leads us to extract a new class **MovieCategory** from **Movie**.

To get the code, check out the **Step11** tag e.g. from the git command line:

    git checkout Step11