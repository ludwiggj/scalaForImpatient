package ch07.lectures.sec06.com.horstmann.impatient

package object people {
  val defaultName = "John Q. Public"
}

package people {
  class Person {
    var name = defaultName // A constant from the package
    // [impatient] ensures that description can be accessed from impatient package, as per example below
    // If ommitted, get error message:
    //
    // method description in class Person cannot be accessed in sec06.com.horstmann.impatient.people.Person
    // println(john.description)

    private[impatient] def description = "A person with name " + name
  }
}

// Run as scala com.horstmann.impatient.Main

object Main extends App {
  val john = new ch07.lectures.sec06.com.horstmann.impatient.people.Person
  println(john.description)
}
