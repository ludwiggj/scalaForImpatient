class Pair[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

val p2 = new Pair[String]("42", "String")
p2.smaller

// Following does not work: see 17_04 for the solution
//val p = new Pair(42, 15)
//p.smaller

class Person(val name: String) {
  override def toString = s"$name"
}
class Student(name: String) extends Person(name)

class Pairy[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pairy[T](newFirst, second)
  override def toString = s"$first $second"
}

val x = new Pairy("Hello", "There")
x.replaceFirst("Goodbye")

val sesameStreet = new Pairy(new Student("Burt"), new Student("Ernie"))
sesameStreet.replaceFirst(new Student("Big Bird"))

// This doesn't work!
// sesameStreet.replaceFirst(new Person("Who dat?"))

val theShop = new Pairy(new Person("Tab A"), new Person("Slot B"))
theShop.replaceFirst(new Person("Animal"))
theShop.replaceFirst(new Student("Mickey"))

class Hairy[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Hairy(newFirst, second)
  override def toString = s"$first $second"
}

val aPair = new Hairy(new Person("Person A"), new Person("Person B"))
aPair.replaceFirst(new Person("Person C"))
aPair.replaceFirst(new Student("Stu Dent"))

val anotherPair = new Hairy(new Student("Student A"), new Student("Student B"))
anotherPair.replaceFirst(new Person("Person C"))
anotherPair.replaceFirst(new Student("Stu Dent"))

new Hairy(new Student("Student A"), new Person("Person B"))

class Mary[T](val first: T, val second: T) {
  def replaceFirst[R](newFirst: R) = new Mary(newFirst, second)
  override def toString = s"$first $second"
}

val aMare = new Mary(new Person("Person A"), new Person("Person B"))
aMare.replaceFirst(new Person("Person C"))
aMare.replaceFirst(new Student("Stu Dent"))

val anotherMare = new Mary(new Student("Student A"), new Student("Student B"))
anotherMare.replaceFirst(new Person("Person C"))
anotherMare.replaceFirst(new Student("Stu Dent"))

new Mary(new Student("Student A"), new Person("Person B"))