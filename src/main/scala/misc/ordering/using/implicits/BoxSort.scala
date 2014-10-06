package misc.ordering.using.implicits

object BoxSort {
  def apply[T](boxes: Seq[Box[T]])(implicit ordering: Ordering[T]) = {
    boxes.sorted(new BoxOrdering(ordering))
  }
}