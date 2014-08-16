abstract class Person {
  val id: Int       // No initializer—this is an abstract field with an abstract getter method
  var name: String  // Another abstract field, with abstract getter and setter methods
  override def toString = getClass.getName + "[id=" + id + ",name=" + name + "]"
}

class Employee(val id: Int) extends Person { // Subclass has concrete id property
  var name = "" // and concrete name property - example of overriding a var with a var
}

val james = new Employee(7)

val fred = new Person {
  val id = 1729
  var name = "Fred"
}