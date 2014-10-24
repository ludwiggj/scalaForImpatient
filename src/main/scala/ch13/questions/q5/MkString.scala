package ch13.questions.q5

object MkString {
  def make[T](col: TraversableOnce[T], separator: String): String = {
    if (col.isEmpty) "" else
    col.reduceLeft((a, b) => {
      (a + separator + b).asInstanceOf[T]
    }).toString
  }
}