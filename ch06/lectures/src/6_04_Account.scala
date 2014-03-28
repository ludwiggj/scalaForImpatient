class Account_04 private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) { balance += amount }
  def description = "Account " + id + " with balance " + balance
}

object Account_04 { // The companion object
  def apply(initialBalance: Double) =
    new Account_04(newUniqueNumber(), initialBalance)
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }

  def main(args: Array[String]) {
    val acct = Account_04(1000.0)
    println(acct.description)
  }
}