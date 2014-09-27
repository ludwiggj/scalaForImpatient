package ch21.lectures.sec03.take2

object MoreFractionFun extends App {

  import conversions.FractionConversions.{fraction3_2_Double => _, _}

  println(s"7 * Fraction3(1, 6) = ${7 * Fraction3(1, 6)}")

  // No implicit conversions used here, since 2 * 2 compiles without conversions
  println(s"2 * 2 = " + (2 * 2))

  // Following won't compile - won't truncate double to int,
  // and won't go from double to fraction4, followed by fraction4 to fraction3

  //  println(s"7.4 * Fraction3(1, 6) = ${7.4 * Fraction3(1, 6)}")

  // Here there are 2 possibilities...
  // 1) double2Fraction1(2.0) * Fraction1(1, 6) => Fraction1 result
  // 2) 2.0 * fraction1_2_Double(Fraction1(1, 6)) => Double result
  //
  // Second conversion wins out, as by default implicit chosen
  // which doesn't convert term on which operator(*) is called
  println(s"2.0 * Fraction1(1, 6) = ${2.0 * Fraction1(1, 6)}")

  // Here's the proof... flip the terms around and the other conversion is called
  println(s"Fraction1(1, 6) * 2.0 = ${Fraction1(1, 6) * 2.0}")

  // This is still ok, even though in other cases 2 is converted to 2.0 so double
  // implicits can be called, here it's not needed
  println(s"Fraction1(1, 6) * 2 = ${Fraction1(1, 6) * 2}")

  // Following doesn't compile, due to ambiguous conversions
  // Following conversions are valid:
  //   fraction2_2_Double
  //   fraction2_2_Double_AndDoubleIt

  //  println(s"2.0 * Fraction2(1, 6) = ${2.0 * Fraction2(1, 6)}")
}