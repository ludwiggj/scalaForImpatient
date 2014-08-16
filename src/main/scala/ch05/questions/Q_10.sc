//10. Consider the class
//class Employee(val name: String, var salary: Double) {
//  def this() { this("John Q. Public", 0.0) }
//}
//Rewrite it to use explicit fields and a default primary constructor. Which form
//do you prefer? Why?

class Employee(val name: String, var salary: Double) {
  def this() { this("John Q. Public", 0.0) }
}

class Employee2(val name: String = "John Q. Public", var salary: Double = 0.0) {
}

class Employee3 {
  private var _name = "John Q. Public"
  var salary = 0.0
  def this(n: String, s: Double) { this(); _name = n; salary = s; }
  def name = _name
}

val e = new Employee
e.name + ", " + e.salary
val e = new Employee("Bob", 25)
e.name + ", " + e.salary
val e = new Employee2
e.name + ", " + e.salary
val e = new Employee2("Bob", 25)
e.name + ", " + e.salary
val e = new Employee3
e.name + ", " + e.salary
val e = new Employee3("Bob", 25)
e.name + ", " + e.salary