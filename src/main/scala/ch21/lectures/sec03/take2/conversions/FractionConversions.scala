package ch21.lectures.sec03.take2.conversions

import scala.language.implicitConversions
import ch21.lectures.sec03.take2.Fraction1
import ch21.lectures.sec03.take2.Fraction2
import ch21.lectures.sec03.take2.Fraction3

object FractionConversions {
   // Implicit conversion so that we can say n * Fraction
   implicit def int2Fraction(n: Int) = Fraction1(n, 1)
   implicit def int2Fraction2(n: Int) = Fraction2(n, 1)
   implicit def int2Fraction3(n: Int) = Fraction3(n, 1)

   implicit def fraction1_2Double(f: Fraction1) = f.num * 1.0 / f.den
   implicit def fraction2_2Double(f: Fraction2) = f.num * 1.0 / f.den
   implicit def fraction3_2Double(f: Fraction3) = f.num * 1.0 / f.den
 }