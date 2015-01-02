import ch17.lectures.{Student, Person}

// Student <: Person
class Pairz[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Pairz[R](newFirst, second)
  override def toString() = s"$first $second"
}

val a = new Pairz(new Person("a"), new Person("b"))
a.replaceFirst(new Student("c"))
a.replaceFirst("a")

// Q8 - why isn't replaceFirst below allowed?
class MutablePairz[T](var first: T, var second: T) {
  def replaceFirst[R >: T](newFirst: R) {
    first = newFirst
  }
  override def toString() = s"$first $second"
}

// This is an example of why this breaks
val b = new MutablePairz(new Student("a"), new Student("b"))

// Now first (which is of type Student) is being assigned
// a Person, which is the supertype
b.replaceFirst(new Person("c"))