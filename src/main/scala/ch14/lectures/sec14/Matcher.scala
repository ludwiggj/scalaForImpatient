package ch14.lectures.sec14

sealed abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount

case object Nothing extends Amount

object Matcher {
  def cashMatch(cash: Amount) = {
    cash match {
      case Dollar(v) => "$" + v
      case a Currency u => s"I got $u $a"
      case Nothing => "Nowt"
    }
  }
}

import Matcher._

object Main extends App {
  println(cashMatch(Dollar(2.34)))
  println(cashMatch(Currency(2.34, "GBP")))
  println(cashMatch(Nothing))

  val v = Currency(2.34, "GBP")
  println(v)
  println(v.copy(value = 3.46))
  println(v.copy(unit = "EUR"))
  println(v.copy(value = 32.46, unit = "CAN"))
}