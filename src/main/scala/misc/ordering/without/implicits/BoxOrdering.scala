package misc.ordering.without.implicits

class BoxOrdering[T](ordering: Ordering[T]) extends Ordering[Box[T]] {
  def compare(x: Box[T], y: Box[T]): Int = ordering.compare(x.value, y.value)
}