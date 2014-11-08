package ch14.lectures.sec11

object Matcher {
  case object +: {
    def unapply[T](input: List[T]) =
      if (input.isEmpty) None else Some((input.head, input.tail))
  }

  def matcher(lst: List[Int]) = {
    val x = lst match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => x + " " + y
      case ::(0, tail) => "0 ...."
      case first +: second +: rest => s"$first $second rest(${rest.length})"
      case _ => "Something else"
    }
    println(s"List $x")
  }
}



import Matcher._

object Main extends App {
  matcher(List(0))
  matcher(List(0, 1))
  matcher(List(0, 1, 2))
  matcher(List(1, 2, 3, 4, 5))
  matcher(List(1))
}