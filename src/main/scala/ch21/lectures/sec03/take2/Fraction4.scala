package ch21.lectures.sec03.take2

import scala.language.postfixOps
import scala.language.implicitConversions

object Fraction4 {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def abs(a: Int): Int = if (a < 0) -a else a

  def apply(n: Int, d: Int) = new Fraction4(n, d)
}

import Fraction4._

class Fraction4(n: Int, d: Int) {
  val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den (Fraction4)"

  def *(other: Fraction4) = Fraction4(num * other.num, den * other.den)
}

object Main4 extends App {
  import conversions.FractionConversions._

  // This works OK - it casts int (7) to double, then uses double2Fraction4
  println(s"${7 * Fraction4(1, 6)}")

  // This uses fraction4_2_Fraction3
  println(s"${Fraction4(1, 6) * Fraction3(1, 6)}")

  // This uses fraction4_2_Fraction3
  println(s"${Fraction3(1, 6) * Fraction4(1, 6)}")

  // This uses fraction3_2_Double
  println(s"${7.4 * Fraction3(1, 6)}")
}