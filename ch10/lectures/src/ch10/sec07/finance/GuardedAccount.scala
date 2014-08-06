package ch10.sec07.finance

import ch10.sec03.finance.Account
import ch10.sec07.Logger

class GuardedAccount(initialBalance: Double)
  extends Account(Account.newUniqueNumber(), initialBalance) with Logger {
  override def withdrawal(amount: Double)  {
    if (amount > balance) {
      severe(s"Insufficient funds: balance [$balance] requested [$amount]")
    } else {
      super.withdrawal(amount)
    }
  }

  def log(msg: String) {
    println(msg)
  }
}