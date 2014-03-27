//7. Write a class Person with a primary constructor that accepts a string containing
//a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
//read-only properties firstName and lastName. Should the primary constructor
//parameter be a var, a val, or a plain parameter? Why?

package questions

// Using plain parameter for fullName has advantage that it doesn't find its way into compiled class file
class Q7_Person(fullName: String) {
  val separator = ' '
  val firstName = fullName.split(separator)(0)
  val lastName = fullName.split(separator)(1)
  def fullname = s"$firstName$separator$lastName"
}

object Q7_Person extends App {
  val p = new Q7_Person("Graeme Ludwig")
  println(s"${p.firstName} ${p.lastName}")
  println(p.fullname)
}