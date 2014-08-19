package ch11.lectures.sec03

import scala.language.postfixOps

class Unary(x: Int) {
  // Only + - ! ~ allowed as prefix unary operators
  def unary_~() = x * x
  override def toString = x toString
}

object Main extends App {
  println(1 toString)
  println(2.toString())

  val z = new Unary(4)
  println(z)

  println(~z)
}