package ch21.lectures.sec06.take2

import scala.language.implicitConversions

object Fraction {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def abs(a: Int): Int = if (a < 0) -a else a

  def apply(n: Int, d: Int) = new Fraction(n, d)

  implicit def fraction2Double(f: Fraction) = {
    print(s"(fraction2Double $f) ")
    f.num * 1.0 / f.den
  }

  // Defining the return type of the following implicit as
  //
  // implicit val fraction2OrderedFraction: Fraction => Ordered[Fraction] =
  //
  // causes an infinite loop: WTF?

  implicit val fraction2OrderedFraction =
    (f: Fraction) => new Fraction(f.num, f.den) with Ordered[Fraction] {
      def compare(that: Fraction): Int = {
        print("fraction2OrderedFraction.compare ")
        if (f < that) -1 else if (f > that) 1 else 0
      }
    }
}

import Fraction._

class Fraction(n: Int, d: Int) {
  private val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  override def toString = s"$num/$den"
}

object Main extends App {
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (order(a) < b) a else b

  println("Fraction(1, 2) < Fraction(3, 5) = ...")
  println(Fraction(1, 2) < Fraction(3, 5))
  println()
  println("Fraction(1, 2) < Fraction(2, 5) = ...")
  println(Fraction(1, 2) < Fraction(2, 5))
  println()
  println("smaller(Fraction(2, 3), Fraction(9, 12)) = ...")
  println(smaller(Fraction(2, 3), Fraction(9, 12)))
  println()
  println("smaller(Fraction(7, 12), Fraction(1, 2)) = ...")
  println(smaller(Fraction(7, 12), Fraction(1, 2)))
  println()
  println("smaller(Fraction(1, 2), Fraction(1, 2)) = ...")
  println(smaller(Fraction(1, 2), Fraction(1, 2)))
}