abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount

def cashMatch(cash: Amount) = {
  cash match {
    case Dollar(v) => "$" + v
    case a Currency u => s"I got $u $a"
    case Nothing => "Nowt"
  }
}

cashMatch(Dollar(2.34))
cashMatch(Currency(2.34, "GBP"))
cashMatch(Nothing)

val v = Currency(2.34, "GBP")
v.copy(value = 3.46)
v.copy(unit = "EUR")
v.copy(value = 32.46, unit = "CAN")