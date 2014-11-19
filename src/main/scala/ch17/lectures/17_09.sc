// Example of an Upper Bound
class Pair[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

val p2 = new Pair[String]("42", "String")
p2.smaller

// Following does not work: see 17_04 for the solution

// val p = new Pair(42, 15)
// p.smaller

// Now introduce Person and Student
// Person is superclass of Student
class Person(val name: String) {
  override def toString = s"$name"
}
class Student(name: String) extends Person(name)