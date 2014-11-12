class Pair[T: Ordering](val first:T, val second:T) {
  def smaller(implicit ord: Ordering[T]) = {
    if (ord.compare(first, second) < 0) first else second
  }

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