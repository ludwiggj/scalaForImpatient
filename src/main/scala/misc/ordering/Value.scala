package misc.ordering

case class Value(i: Int) extends Ordered[Value] {
  def compare(that: Value) = this.i - that.i
}

object Value extends App {
  val valueList = List(Value(1), Value(2), Value(3), Value(2), Value(1))
  println(valueList.sorted)
}