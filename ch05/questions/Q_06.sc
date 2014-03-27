//6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
//on page 51, provide a primary constructor that turns negative ages to 0.

class Person(a: Int) {
  val age = {
    if (a < 0) 0 else a
  }
}

(new Person(-5)).age
(new Person(0)).age
(new Person(20)).age
//(new Person(20)).age = 25