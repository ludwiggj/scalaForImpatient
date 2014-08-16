// It is more common to override an abstract def with a val

abstract class Person { // See Section 8.8 for abstract classes
  def id: Int // Each person has an ID that is computed in some way
}

// override is optional here
class Student(override val id: Int) extends Person

class SecretAgent extends Person {
  // override is optional here
  override val id = scala.util.Random.nextInt
}
val fred = new Student(1729)
fred.id
val james = new SecretAgent
james.id