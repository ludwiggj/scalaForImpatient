package ch08.lectures.sec04

class Person {
  protected[this] var age = 0
  protected var sex = "Unknown"
  def setAge(newAge: Int) { // A person can never get younger
    if (newAge > age) age = newAge
  }
}

class Manager extends Person {
  protected var salary = 0.0
  def setSalary(newSalary: Double) { // A manager's salary can never decrease
    if (newSalary > salary) salary = newSalary
  }
  def setSex(sex: String) {
    this.sex = sex
  }
  // Can access age from superclass
  // Can access sex from superclass
  def description = "a manager who is " + age +
    " years old, is " + sex + " and makes " + salary

  def isSeniorTo(other: Manager) =
    salary > other.salary
    // Can't access age of another person. The following doesn't work:
    // age > other.age
}

object Main extends App {
  var fred = new Manager
  fred.setAge(50)
  fred.setSalary(100000)
  fred.setSex("male")
  var wilma = new Manager
  wilma.setAge(55)
  wilma.setSalary(90000)
  wilma.setSex("female")
  if (fred.isSeniorTo(wilma))
    println(fred.description + "\nis senior to " + wilma.description)
  else
    println(wilma.description + "\nis senior to " + fred.description)

  // Following not allowed...

//  println(wilma.sex)

//  variable sex in class Person cannot be accessed in ch08.sec04.Manager
//  Access to protected method sex not permitted because
//  enclosing object Main in package sec04 is not a subclass of
//  class Person in package sec04 where target is defined
//  println(wilma.sex)
}

