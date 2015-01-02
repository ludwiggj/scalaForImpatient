package ch17.questions.q3

// Q3: Given a class Pair[T, S], write a generic method swap that takes a pair
//     as its argument and returns a new pair with the components swapped

class Pair[T, S] (val first:T, val second: S) {
  override def toString = s"($first, $second)"
}

object Main extends App {
  def swap[T, S](p: Pair[T, S]) = new Pair(p.second, p.first)

  val aPair = new Pair(2.65, "two point six five")
  println(aPair)
  println(swap(aPair))
}