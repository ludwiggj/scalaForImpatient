package ch11.lectures.sec08

import scala.language.postfixOps

class Fraction(n: Int, d: Int) {
  private val num = n
  private val den = d

  override def toString = s"$num/$den"

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)

  def unapply(input: Fraction) =
    if (input.den == 0) None else Some((input.num, input.den))
}

object Main extends App {
  private val a = Fraction(3, 6)
  private val b = Fraction(8, 10)
  println(s"$a * $b = ${a * b}")

  var Fraction(x, y) = a * b
  println(s"F1 => $x/$y")

  // Following results in Exception in thread "main" scala.MatchError
  //  var Fraction(u, v) = Fraction(6, 0)
  //  println(s"F2 => $u/$v")

  Fraction(6, 0) match {
    case Fraction(x0, y0) => println(s"F3 => $x0/$y0")
    case _ => println("No match")
  }

  Fraction(0, 9) match {
    case Fraction(x0, y0) => println(s"F3 => $x0/$y0")
    case _ => println("No match")
  }
}