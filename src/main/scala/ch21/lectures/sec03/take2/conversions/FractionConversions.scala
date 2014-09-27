package ch21.lectures.sec03.take2.conversions

import scala.language.implicitConversions
import ch21.lectures.sec03.take2.{Fraction4, Fraction1, Fraction2, Fraction3}

object FractionConversions {
  // Implicit conversion so that we can say n * Fraction1
  implicit def int2Fraction1(n: Int) = {
    println(s"... int2Fraction1 called, n=$n")
    Fraction1(n, 1)
  }

  implicit def double2Fraction1(n: Double) = {
    println(s"... double2Fraction1 called, n=$n")
    Fraction1(n.toInt, 1)
  }

  implicit def int2Fraction2(n: Int) = {
    println(s"... int2Fraction2 called, n=$n")
    Fraction2(n, 1)
  }

  implicit def int2Fraction3(n: Int) = {
    println(s"... int2Fraction3 called, n=$n")
    Fraction3(n, 1)
  }

  implicit def double2Fraction4(n: Double) = {
    println(s"... double2Fraction4 called, n=$n")
    Fraction4(n.toInt, 1)
  }

  implicit def fraction4_2_Fraction3(f: Fraction4) = {
    println(s"... fraction4_2_Fraction3 called, f=$f")
    Fraction3(f.num, f.num)
  }

  implicit def fraction1_2_Double(f: Fraction1) = {
    println(s"... fraction1_2_Double called, f=$f")
    f.num * 1.0 / f.den
  }

  implicit def fraction3_2_Double(f: Fraction3) = {
    println(s"... fraction3_2_Double called, f=$f")
    f.num * 1.0 / f.den
  }

  // Provide 2 conversions from fraction2 to double to test ambiguity rules
  implicit def fraction2_2_Double(f: Fraction2) = {
    println(s"... fraction2_2_Double called, f=$f")
    f.num * 1.0 / f.den
  }

  implicit def fraction2_2_Double_AndDoubleIt(f: Fraction2) = {
    println(s"... fraction2_2_Double_AndDoubleIt called, f=$f")
    f.num * 2.0 / f.den
  }
}