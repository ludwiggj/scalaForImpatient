package ch10.lectures.sec03.finance

import ch10.lectures.sec03.ConsoleLogger

class GuardedAccount(initialBalance: Double) extends Account(Account.newUniqueNumber(), initialBalance) with ConsoleLogger {
  override def withdrawal(amount: Double)  {
    if (amount > balance) {
      log(s"Insufficient funds: balance [$balance] requested [$amount]")
    } else {
      super.withdrawal(amount)
    }
  }
}
object GuardedAccount { // The companion object
  def apply(initialBalance: Double) =
    new GuardedAccount(initialBalance)
}