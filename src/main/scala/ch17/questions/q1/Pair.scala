package ch17.questions.q1

// Q1: Define immutable class Pair[T, S] with a method swap that returns a new
//     pair with the components swapped

class Pair[T, S] (val first:T, val second: S) {
  def swap: Pair[S, T] = new Pair(second, first)
  override def toString = s"($first, $second)"
}

object Main extends App {
  val aPair = new Pair(2, "two")
  println(aPair)
  println(aPair.swap)
}