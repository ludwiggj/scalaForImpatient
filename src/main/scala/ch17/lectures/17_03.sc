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

import ch17.lectures.{Person, Student}

// ========= Pairy ============

// replaceFirst method replaces first item
// No bounds used in this definition
class Pairy[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pairy[T](newFirst, second)
  override def toString = s"$first $second"
}

val x = new Pairy("Hello", "There")
x.replaceFirst("Goodbye")

val sesameStreet = new Pairy(new Student("Burt"), new Student("Ernie"))
sesameStreet.replaceFirst(new Student("Big Bird"))

// This doesn't work! Cannot replace Student with its superclass, Person
// sesameStreet.replaceFirst(new Person("Who dat?"))

val theShop = new Pairy(new Person("Tab A"), new Person("Slot B"))
theShop.replaceFirst(new Person("Animal"))

// It's OK to replace item with its subclass
theShop.replaceFirst(new Student("Mickey"))


// ========= Hairy ============

// Now type of item that replaces first item can be a supertype of existing item

// This is a Lower bound
class Hairy[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Hairy(newFirst, second)
  override def toString = s"$first $second"
}

// Following is expected i.e. can replace Person with Student
val aPair = new Hairy(new Person("Person A"), new Person("Person B"))
aPair.replaceFirst(new Person("Person C"))
aPair.replaceFirst(new Student("Stu Dent"))

// But now we can also replace Student with a Person, thanks to lower bound
val anotherPair = new Hairy(new Student("Student A"), new Student("Student B"))
anotherPair.replaceFirst(new Person("Person C"))
anotherPair.replaceFirst(new Student("Stu Dent"))

new Hairy(new Student("Student A"), new Person("Person B"))

// ========= Hairy ============

// In this case replaceFirst specifies a new type R, but it is not related to existing type T
class Mary[T](val first: T, val second: T) {
  def replaceFirst[R](newFirst: R) = new Mary(newFirst, second)
  override def toString = s"$first $second"
}

// So now any replacements result in Mary[Any]
val aMare = new Mary(new Person("Person A"), new Person("Person B"))
aMare.replaceFirst(new Person("Person C"))
aMare.replaceFirst(new Student("Stu Dent"))

val anotherMare = new Mary(new Student("Student A"), new Student("Student B"))
anotherMare.replaceFirst(new Person("Person C"))
anotherMare.replaceFirst(new Student("Stu Dent"))

new Mary(new Student("Student A"), new Person("Person B"))