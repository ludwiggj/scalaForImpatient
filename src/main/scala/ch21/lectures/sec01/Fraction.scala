package ch21.lectures.sec01

import scala.language.postfixOps
import scala.language.implicitConversions

object Fraction {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  def abs(a: Int): Int = if (a < 0) -a else a
  def apply(n: Int, d: Int) = new Fraction(n, d)

  // Implicit conversion so that we can say 3 * Fraction
  implicit def int2Fraction(n: Int) = Fraction(n, 1)
}


import Fraction._

class Fraction(n: Int, d: Int) {
  private val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den"

  def *(other: Fraction) = Fraction(num * other.num, den * other.den)
}

object Main extends App {
  println(s"${Fraction(3, 6)}")

  // 3 converted to Fraction via an implicit as type of parameters of * method
  // don't match the supplied arguments
  println(s"${3 * Fraction(3, 6)}")

  println(s"${Fraction(3,1) * Fraction(6, 1)}")

  println(s"${3 * Fraction(6, 1)}")

  // No implicit conversion used here, as code already compiles without it!
  println(s"${3 * 6}")
}