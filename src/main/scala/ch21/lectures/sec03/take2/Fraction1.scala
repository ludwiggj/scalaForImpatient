package ch21.lectures.sec03.take2

import scala.language.postfixOps
import scala.language.implicitConversions
import scala.math.sqrt

object Fraction1 {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  def abs(a: Int): Int = if (a < 0) -a else a
  def apply(n: Int, d: Int) = new Fraction1(n, d)
}

import Fraction1._

class Fraction1(n: Int, d: Int) {
  val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den (Fraction1)"

  def *(other: Fraction1) = Fraction1(num * other.num, den * other.den)
}

object Main1 extends App {
  println(s"${Fraction1(3, 6)}")

  // Following uses fraction1_2Double by default
  import conversions.FractionConversions._
  println(s"2 * Fraction1(1, 6) = ${2 * Fraction1(1, 6)}")

  // Fraction automatically converted to double via implicit
  // to fulfil type signature of sqrt
  // (Also stated as type of an expression differs from expected type)
  println(s"sqrt(1/4) = ${sqrt(Fraction1(1, 4))}")
}