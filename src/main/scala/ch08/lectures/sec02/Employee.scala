package ch08.lectures.sec02

class Person {
  var name = ""
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary + "]"
}

object Main extends App {
  val fred = new Employee
  fred.name = "Fred"
  fred.salary = 50000
  println(fred)

  val bob = new Person
  bob.name = "Bobert"
  println(bob)
}