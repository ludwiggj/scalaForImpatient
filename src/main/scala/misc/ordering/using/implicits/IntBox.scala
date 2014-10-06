package misc.ordering.using.implicits

import scala.language.implicitConversions

case class IntBox(value: Int) extends Box[Int] {
  def +(other: IntBox) = IntBox(value + other.value)
}

object IntBox extends App {
  val a = IntBox(3)
  val b = IntBox(4)

  println(a + b)
  println(3 + 4)

  // Can't do this yet...
  // println(a + 4)

  implicit def intToIntBox(int: Int): IntBox = IntBox(int)

  // Now I can!

  println(a + 4)

  val list = List(IntBox(1), IntBox(2), IntBox(3), IntBox(2), IntBox(1))
  println(BoxSort(list))
}