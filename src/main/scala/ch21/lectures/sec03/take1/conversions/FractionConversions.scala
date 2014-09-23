package ch21.lectures.sec03.conversions

import scala.language.implicitConversions
import ch21.lectures.sec03.take1.Fraction1
import ch21.lectures.sec03.take1.Fraction2

object FractionConversions {
  // Implicit conversion so that we can say n * Fraction
  implicit def int2Fraction(n: Int) = Fraction1(n, 1)
  implicit def int2Fraction2(n: Int) = Fraction2(n, 1)
}