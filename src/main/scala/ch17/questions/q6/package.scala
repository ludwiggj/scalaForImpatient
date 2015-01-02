package ch17.questions

package object q6 {
  def middle[T](iter: Iterable[T]): Option[T] = {
    val midpoint = iter.size / 2
    iter.drop(midpoint).headOption
  }
}
