package ch10.sec11.finance

import ch10.sec03.finance.Account
import ch10.sec11.FileLogger

class GuardedAccount(initialBalance: Double) extends {
  val filename = "savings.log"
} with Account(Account.newUniqueNumber(), initialBalance) with FileLogger {
  override def withdrawal(amount: Double)  {
    if (amount > balance) {
      log(s"Insufficient funds: balance [$balance] requested [$amount]")
    } else {
      super.withdrawal(amount)
    }
  }
}