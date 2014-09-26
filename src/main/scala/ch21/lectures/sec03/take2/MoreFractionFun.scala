package ch21.lectures.sec03.take2

object MoreFractionFun extends App {

  import conversions.FractionConversions.{fraction3_2_Double => _, _}

  println(s"${7 * Fraction3(1, 6)}")

  // Following won't compile - won't truncate double to int,
  // and won't go from double to fraction4, followed by fraction4 to fraction3

  // println(s"${7.4 * Fraction3(1, 6)}")
}