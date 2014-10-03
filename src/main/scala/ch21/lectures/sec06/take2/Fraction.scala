package ch21.lectures.sec06.take2

import scala.language.implicitConversions

object Fraction {
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def abs(a: Int): Int = if (a < 0) -a else a

  def apply(n: Int, d: Int) = new Fraction(n, d)

  implicit def fraction2Double(f: Fraction) = {
    print(s"fraction2Double($f) ")
    f.num * 1.0 / f.den
  }

  // Defining the return type of the following implicit as
  //
  // implicit val fraction2OrderedFraction: Fraction => Ordered[Fraction] =
  //
  // causes an infinite loop: WTF?

  implicit val fraction2OrderedFraction =
    (f: Fraction) => {
      print(s"fraction2OrderedFraction($f) ")
      new Fraction(f.num, f.den) with Ordered[Fraction] {

        def compare(that: Fraction): Int = {
          print(s"fraction2OrderedFraction.compare($f, $that) ")
          val fAsDouble: Double = f
          val thatAsDouble: Double = that
          if (fAsDouble < thatAsDouble) -1 else if (fAsDouble > thatAsDouble) 1 else 0
        }
      }
    }

  implicit def int2Fraction(n: Int) = {
    Fraction(n, 1)
  }
}

import Fraction._

class Fraction(n: Int, d: Int) {
  private val num = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def *(other: Fraction) = Fraction(num * other.num, den * other.den)

  override def toString = s"$num/$den"
}

object Main extends App {
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (order(a) < b) a else b

  println("Fraction(1, 2) < Fraction(3, 5) = ...")
  println("This uses fraction2OrderedFraction rather than fraction2Double")
  println(Fraction(1, 2) < Fraction(3, 5))
  println()

  // Compare routine makes implicit conversion from fraction to double
  // more explicit so only performed once per fraction
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
  println()

  //  2 * Fraction(2, 3) = 1.3333
  println("2 * Fraction(2, 3) = ...")
  println(2 * Fraction(2, 3))
  println()

  // Following line files to compile wth message:
  // No implicit view available from Any => Ordered[Any].
  // This is because first expression is implicitly
  // converted to a double, whereas second term is a
  // fraction, hence scala generalises type to Any
  // Compiler isn't smart enough to convert second term
  // to a double...

  // println(smaller(2 * Fraction(2, 3), Fraction(9, 12)))

  // But we can help it by giving it a hint, multiplying
  // second term by 1
  println("smaller(2 * Fraction(2, 3), 1 * Fraction(9, 12)) = ...")
  println(smaller(2 * Fraction(2, 3), 1 * Fraction(9, 12)))
  println()

  // No such problem if we flip the multiplicants in first term...
  // println("smaller(2 * Fraction(2, 3), Fraction(9, 12)) = ...")

  // Fraction(2, 3) * 2 = 4/3
  println("Fraction(2, 3) * 2 = ...")
  println(Fraction(2, 3) * 2)
  println()

  println("smaller(Fraction(2, 3) * 2, Fraction(9, 12)) = ...")
  println(smaller(Fraction(2, 3) * 2, Fraction(9, 12)))
}