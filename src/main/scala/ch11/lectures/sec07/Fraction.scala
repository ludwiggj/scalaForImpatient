package ch11.lectures.sec07

import scala.collection.mutable
import scala.language.postfixOps

class Fraction(n: Int, d: Int) {
  private var num = n
  private var den = d

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  override def toString = s"$num/$den"

  def apply(property: String): String = property match {
    case "nom" => num toString
    case "denom" => den toString
    case x => s"Property $x is invalid"
  }

  def update(property: String, newVal: Int) = property match {
    case "nom" => num = newVal
    case "denom" => den = newVal
    case _ =>
  }
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
}

object Main extends App {
  private val a = Fraction(3, 6)
  private val b = Fraction(8, 10)
  println(s"$a * $b = ${a * b}")

  a("nom") = 6
  b("denom") = 20

  println(s"$a * $b = ${a * b}")

  println(b("nom"))
  println(b("denom"))
  println(a("hmmmm"))

  val scores = new mutable.HashMap[String, Int]
  scores("Bob") = 100
  val bobsScore = scores("Bob")
}