// [T: Ordering] means that there must be an implicit
// value of type Ordering[T]

class Pair[T: Ordering](val first:T, val second:T) {
  // It can be declared as an implicit parameter
  // to a method that wishes to use it
  def smaller(implicit ord: Ordering[T]) = {
    if (ord.compare(first, second) < 0) first else second
  }

  // Or it can be "summoned from the ether" via
  // the implictly keyword
  def larger() = {
    if (implicitly[Ordering[T]].compare(first, second) < 0) second else first
  }

  override def toString() = s"$first $second"
}

val x = new Pair(2, 5)
x.smaller
x.larger

val y = new Pair("Wombat", "Aardvark")
y.smaller
y.larger