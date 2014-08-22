package ch11.questions.q3

import scala.language.postfixOps

object Fraction {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  def abs(a: Int): Int = if (a < 0) -a else a
  def apply(n: Int, d: Int) = new Fraction(n, d)
}

import Fraction._

class Fraction(n: Int, d: Int) {
  private val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den"

  def *(other: Fraction) = Fraction(num * other.num, den * other.den)
  def -(other: Fraction) = Fraction(num * other.den - other.num * den, den * other.den)
  def +(other: Fraction) = Fraction(num * other.den + other.num * den, den * other.den)
  def /(other: Fraction) = this * Fraction(other.den, other.num)
}


object Main extends App {
  private val a = Fraction(3, 6)
  private val b = Fraction(8, 10)
  private val c = Fraction(-5, 5)
  private val d = Fraction(3, -2)
  private val e = Fraction(3, 0)
  private val f = Fraction(-3, 0)
  private val g = Fraction(0, 2)
  private val h = Fraction(0, -6)

  println(s"$a $b $c $d $e $f $g $h")
  println(gcd(3, -2))
  println(gcd(-3, -2))
  println(gcd(-3, 0))
  println(gcd(3, 0))

  println(s"$a * $b = ${a * b}")
  println(s"$a - $b = ${a - b}")
  println(s"$b - $a = ${b - a}")
  println(s"$b - $b = ${b - b}")
  println(s"$a + $b = ${a + b}")
  println(s"$b + $a = ${b + a}")
  println(s"$b + $b = ${b + b}")
  println(s"$a / $b = ${a / b}")
  println(s"$b / $a = ${b / a}")
  println(s"$b / $b = ${b / b}")
}