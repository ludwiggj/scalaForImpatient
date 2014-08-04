package ch10.sec04

import scala.util.logging.Logged

class GuardedAccount(initialBalance: Double) extends Account(Account.newUniqueNumber(), initialBalance) with Logged {
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