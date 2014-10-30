refactoringMovies (Start)
=========================

This is the starting position of the refactoring movie exercise.

The code represents a **customer** who can rent **movies** of different **genres**; **regular**, **new release** and **children's**. A **rental** can last one or more days. The rental generates a **charge** to the customer, and can also result in one or more **frequent rental points**, which the customer can presumably exchange for goodies at a later date :)

The customer class provides a **statement** method which returns a textual statement, like he/she would receive from their "movie provider".

There is a single customer test, **shouldGiveCorrectStatementForCustomerWithRentals**, which verifies this behaviour.

Please examine the code before moving on.

* The **Fixture** class contains known movie and rental test objects that can be used within various tests.
* The **Movie** and **Rental** classes are quite simple.
* The **Customer statement** method is far too complex. It breaks the [single responsibility principle] (http://en.wikipedia.org/wiki/Single_responsibility_principle), and is the focus of the refactoring carried out in this exercise.

Note that having a single test for this code base is not ideal, but this situation is not unusual, especially when dealing with legacy code bases. More test cases will be added as we go.