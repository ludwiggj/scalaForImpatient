package ch21.lectures.sec03.take2

import scala.language.postfixOps
import scala.language.implicitConversions

object Fraction2 {
   def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

   def abs(a: Int): Int = if (a < 0) -a else a

   def apply(n: Int, d: Int) = new Fraction2(n, d)
 }

import Fraction2._

class Fraction2(n: Int, d: Int) {
   val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
   val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

   def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

   override def toString = s"$num/$den"

   def *(other: Fraction2) = Fraction2(num * other.num, den * other.den)
 }

object Main2 extends App {
   println(s"${Fraction2(3, 6)}")
   println(s"${2 * Fraction2(1, 6)}")
 }