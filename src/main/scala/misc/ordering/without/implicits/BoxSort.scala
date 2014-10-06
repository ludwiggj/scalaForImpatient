package misc.ordering.without.implicits

object BoxSort {
  def apply[T](boxes: Seq[Box[T]])(ordering: Ordering[T]) = {
    boxes.sorted(new BoxOrdering(ordering))
  }
}