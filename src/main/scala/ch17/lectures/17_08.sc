import java.io.File

import scala.runtime.RichInt

// Type constraints
// T <:< ... T is a sub-type of...
class Pair[T](val first: T, val second: T)(implicit ev: T <:< Comparable[T]) {
  def smaller = if (first.compareTo(second) < 0) first else second
  def larger = if (first.compareTo(second) >= 0) first else second
  override def toString = s"$smaller $larger"
}

// Error: Cannot prove that Int <:< Comparable[Int].
// val p = new Pair(42, 15)
val q = new Pair("Zebra", "Alligator")
val r = new Pair("Aardvark", "Alligator")

// <%< type constraint is no longer supported
// class Hairy[T](val first: T, val second: T)(implicit ev: T <%< Comparable[T]) {
// It is now expressed as follows...
class Hairy[T](val first: T, val second: T)(implicit ev: T => Comparable[T]) {
  def smaller = if (first.compareTo(second) < 0) first else second
  def larger = if (first.compareTo(second) >= 0) first else second
  override def toString = s"$smaller $larger"
}
val s = new Hairy(42, 15)
val t = new Hairy("Zebra", "Alligator")
val u = new Hairy("Aardvark", "Alligator")

class Pairy[T, U](val first: T, val second: U)(implicit ev: T =:= U) {
  override def toString = s"$first $second"
}

new Pairy(42, 15)

// Error: Cannot prove that Int =:= scala.runtime.RichInt.
// new Pairy(42, new RichInt(15))

// Error: Cannot prove that Int =:= String.
// new Pairy(42, "15")

// Introduce type constraint on specific methods
class Mary[T](val first: T, val second: T) {
  def smaller(implicit ev: T => Comparable[T]) = if (first.compareTo(second) < 0) first else second
  def larger(implicit ev: T => Comparable[T]) = if (first.compareTo(second) >= 0) first else second
  def getOrder(implicit ev: T => Comparable[T]) = s"$smaller $larger"
  override def toString = s"1 [$first] 2 [$second]"
}

val v = new Mary(231, 71)
v.getOrder

val x = new Mary(new File("a.txt"), new File("b.txt"))
x.getOrder
x.smaller
x.larger

class Orange {}
val zz = new Mary(new Orange(), new Orange())

// Error: No implicit view available from A$A64.this.Orange => Comparable[A$A64.this.Orange].
// zz.smaller
// zz.larger

// Another type constraint example, orNull method

val friends = Map("Fred" -> "Barney")

val friendOpt = friends.get("Wilma")

val friendOrNull = friendOpt.orNull

val friendsAges = Map("Fred" -> 22, "Barney" -> 34)

val friendsAgesOpt: Option[Int] = friendsAges.get("Fred")

// Error: Cannot prove that Null <:< Int.
// val friendsAgesNull = friendsAgesOpt.orNull