package ch10.lectures.sec03.finance

class Account (val id: Int, initialBalance: Double) {
  var balance = initialBalance
  def deposit(amount: Double) { balance += amount }
  def withdrawal(amount: Double)  { balance -= amount }
  def description = "Account " + id + " with balance " + balance
  override def toString = description
}

object Account { // The companion object
  def apply(initialBalance: Double) =
    new Account(newUniqueNumber(), initialBalance)

  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber }

  def main(args: Array[String]) {
    val acct = Account(1000.0)
    println(acct.description)
  }
}