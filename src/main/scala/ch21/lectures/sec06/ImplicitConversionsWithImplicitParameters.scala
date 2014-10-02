package ch21.lectures.sec06

object ImplicitConversionsWithImplicitParameters extends App {
  def enlister[T]: T => List[T] = List(_)

  val listOfInt = enlister(8)
  val listOfDouble = enlister(8.0)
  val listOfString = enlister("scala is powerful yet tricky")

  println(s"listOfInt=$listOfInt")
  println(s"listOfDouble=$listOfDouble")
  println(s"listOfString=$listOfString")

//  def smaller[T](a: T, b: T)(order: T => Ordered[T]) = if (order(a) < b) a else b
//  def orderer[T]: T => Ordered[T] = (x: T) => Ordered[T]
//  println(smaller[Int](40, 2)(orderer))

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (order(a) < b) a else b

  println(smaller(40, 2))
  println(smaller("This", "Alice"))
}