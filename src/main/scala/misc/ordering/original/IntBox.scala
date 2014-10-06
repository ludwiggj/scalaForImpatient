package misc.ordering.original

case class IntBox(value: Int) extends Box[Int]

object IntBox extends App {
  val sort = new BoxSort(new BoxOrdering(scala.math.Ordering.Int))
  val list = List(IntBox(15), IntBox(2), IntBox(3), IntBox(2), IntBox(1))
  println(sort(list))
}