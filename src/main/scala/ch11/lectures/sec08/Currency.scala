package ch11.lectures.sec08

case class Currency(value: Double, unit: String)

object Main2 extends App {
  def displayCurrency(dosh: Currency) {
    dosh match {
      case Currency(amount, "USD") => println("$" + amount)
      case Currency(_, x) => println(s"Unknown currency $x")
    }
  }

  displayCurrency(Currency(29.95, "EUR"))
  displayCurrency(Currency(29.95, "USD"))
}