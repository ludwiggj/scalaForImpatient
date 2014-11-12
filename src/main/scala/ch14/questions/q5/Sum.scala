package ch14.questions.q5

object Sum {

  def sumLeaf(list: List[Any]): Int = {
    (for (elem <- list) yield (
      elem match {
        case x: List[Int] => sumLeaf(x)
        case x: Int => x
        case _ => 0
      }
      )).sum
  }

  def sumLeaf2(list: List[Any]): Int = {
    (list map { elem =>
      elem match {
        case x: List[Int] => sumLeaf2(x)
        case x: Int => x
        case _ => 0
      }
    }).sum
  }
}

import Sum._

object Main extends App {
  val x = List(List(3, 8), 2, List(5))
  println(x)
  println(sumLeaf(x))
  println(sumLeaf2(x))
}