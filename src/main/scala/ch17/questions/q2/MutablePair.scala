package ch17.questions.q2

// Q1: Define mutable class Pair[T] with a method swap that
//     swaps the components of the pair

class MutablePair[T] (var first:T, var second: T) {
  def swap: Unit = {
    val temp = first
    first = second
    second = temp
  }
  override def toString = s"($first, $second)"
}

object Main extends App {
  val aPair = new MutablePair("one", "two")
  println(aPair)
  aPair.swap
  println(aPair)
}