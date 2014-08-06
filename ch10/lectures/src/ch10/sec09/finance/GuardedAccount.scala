package ch10.sec09.finance

import ch10.sec03.finance.Account
import ch10.sec09.ShortLogger
import ch10.sec04.ConsoleLogger

class GuardedAccount(initialBalance: Double)
  extends Account(Account.newUniqueNumber(), initialBalance) with ConsoleLogger with ShortLogger {
  override def withdrawal(amount: Double)  {
    if (amount > balance) {
      log(s"Insufficient funds: balance [$balance] requested [$amount]")
    } else {
      super.withdrawal(amount)
    }
  }

  val maxLength: Int = 10
}