// <: is upper bound, but can't make use of implicits
// <% is a view bound, which can make use of implicits

// T <% Comparable[T] means that there must be an implicit
// conversion from T to Comparable[T]

class Pair[T <% Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
  override def toString = s"$first $second"
}

// This now works.
// Int doesn't implement Comparable[Int]
// But it can be converted to RichInt via an implicit
// And RichInt does implement Comparable[Int]
val p = new Pair(42, 15)
p.smaller

val q = new Pair("Zebra", "Alligator")
q.smaller

// Using Ordered instead of Comparable makes for nicer syntax
class AnotherPair[T <% Ordered[T]](val first: T, val second: T) {
  def smaller = if (first < second) first else second
  override def toString = s"$first $second"
}

val r = new AnotherPair(42, 150)
r.smaller

val s = new Pair("Spider", "Walrus")
s.smaller