package misc.ordering.original

class BoxSort[T](ordering: Ordering[Box[T]]) {
  def apply(boxes: Seq[Box[T]]) = {
    boxes.sorted(ordering)
  }
}