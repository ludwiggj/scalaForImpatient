package ch21.lectures.sec03.take2

import scala.language.postfixOps
import scala.language.implicitConversions

object Fraction3 {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def abs(a: Int): Int = if (a < 0) -a else a

  def apply(n: Int, d: Int) = new Fraction3(n, d)
}

import Fraction3._

class Fraction3(n: Int, d: Int) {
  val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den (Fraction3)"

  def *(other: Fraction3) = Fraction3(num * other.num, den * other.den)
}

object Main3 extends App {
  println(s"${Fraction3(3, 6)}")

  // Import all conversions except fraction3_2Double
  import conversions.FractionConversions.{fraction3_2_Double => _, _}

  // Thus int2Fraction3 is used...
  println(s"2 * Fraction3(1, 6) = ${2 * Fraction3(1, 6)}")
}