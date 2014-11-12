class Pair[T <% Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
  override def toString = s"$first $second"
}

val p = new Pair(42, 15)
p.smaller

val q = new Pair("Zebra", "Alligator")
q.smaller

class AnotherPair[T <% Ordered[T]](val first: T, val second: T) {
  def smaller = if (first < second) first else second
  override def toString = s"$first $second"
}

val r = new AnotherPair(42, 150)
r.smaller

val s = new Pair("Spider", "Walrus")
s.smaller