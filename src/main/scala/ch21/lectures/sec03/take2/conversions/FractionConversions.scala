package ch21.lectures.sec03.take2.conversions

import scala.language.implicitConversions
import ch21.lectures.sec03.take2.{Fraction4, Fraction1, Fraction2, Fraction3}

object FractionConversions {
   // Implicit conversion so that we can say n * Fraction
   implicit def int2Fraction(n: Int) = Fraction1(n, 1)
   implicit def int2Fraction2(n: Int) = Fraction2(n, 1)
   implicit def int2Fraction3(n: Int) = Fraction3(n, 1)

   implicit def double2Fraction4(n: Double) = Fraction4(n.toInt, 1)
   implicit def fraction4_2_Fraction3(f: Fraction4) = Fraction3(f.num, f.num)

   implicit def fraction1_2_Double(f: Fraction1) = f.num * 1.0 / f.den
   implicit def fraction2_2_Double(f: Fraction2) = f.num * 1.0 / f.den
   implicit def fraction3_2_Double(f: Fraction3) = f.num * 1.0 / f.den
 }