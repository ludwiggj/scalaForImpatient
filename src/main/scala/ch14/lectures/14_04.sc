def matcher(obj: Any) = {
  obj match {
    case x: Int => x
    case s: String => Integer.parseInt(s)
    case _: BigInt => Int.MaxValue
    case BigInt => -1
    case Array => -5
    case _: Array[Int] => -7
    case _: Array[String] => -8
    case _: Map[String, String] => -9
    case _ => 0
  }
}

matcher(7)
matcher("64")
matcher(BigInt(6))
matcher(BigInt)
matcher(Array)
matcher(Array(1))
matcher(Array("1"))
matcher(Map("1" -> "8"))
matcher(Map(1 -> "8"))
matcher(2.4)