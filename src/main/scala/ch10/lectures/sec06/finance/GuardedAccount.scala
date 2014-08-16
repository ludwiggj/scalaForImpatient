package ch10.lectures.sec06.finance

import ch10.lectures.sec03.finance.Account
import ch10.lectures.sec02.Logger

abstract class GuardedAccount(initialBalance: Double)
  extends Account(Account.newUniqueNumber(), initialBalance) with Logger {
  override def withdrawal(amount: Double)  {
    if (amount > balance) {
      log(s"Insufficient funds: balance [$balance] requested [$amount]")
    } else {
      super.withdrawal(amount)
    }
  }
}