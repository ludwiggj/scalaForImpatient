package misc.ordering

case class UnorderedValue(i: Int)

object UnorderedValue extends App {
  val unorderedValueList = List(UnorderedValue(1), UnorderedValue(2), UnorderedValue(3),
    UnorderedValue(2), UnorderedValue(1))

  println(unorderedValueList)

  // Can't do following, as no Ordering defined for UnorderedValue
  // println(unorderedValueList.sorted)
}