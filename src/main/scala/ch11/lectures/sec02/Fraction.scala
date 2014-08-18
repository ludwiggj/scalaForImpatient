package ch11.lectures.sec02

class Fraction(n: Int, d: Int) {
  private val num = n
  private val den = d

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  override def toString = s"$num/$den"
}

object Main extends App {
  private val a = new Fraction(3, 6)
  private val b = new Fraction(8, 10)
  println(s"$a * $b = ${a * b}")
}