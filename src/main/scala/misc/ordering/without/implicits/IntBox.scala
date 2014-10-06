package misc.ordering.without.implicits

case class IntBox(value: Int) extends Box[Int]

object IntBox extends App {
  val list = List(IntBox(1), IntBox(22), IntBox(3), IntBox(2), IntBox(1))
  println(BoxSort(list)(scala.math.Ordering.Int))
}