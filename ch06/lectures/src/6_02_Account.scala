
class Account_02 {
  val id = Account_02.newUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }

  def description = "Account " + id + " with balance " + balance
}

object Account_02 {
  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1; lastNumber
  }

  def main(args: Array[String]): Unit = {
    val acct1 = new Account_02
    val acct2 = new Account_02
    acct1.deposit(1000)
    println(acct1.description)
    println(acct2.description)
  }
}