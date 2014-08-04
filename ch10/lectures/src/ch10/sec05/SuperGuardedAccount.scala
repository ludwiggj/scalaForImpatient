package ch10.sec05

import scala.util.logging.Logged
import ch10.sec04.Account

class SuperGuardedAccount(initialBalance: Double) extends Account(Account.newUniqueNumber(), initialBalance)
with ConsoleLogger with TimestampLogger with ShortLogger with Logged {
  override def withdrawal(amount: Double) {
    if (amount > balance) {
      val msg = s"Insufficient funds: balance [$balance] requested [$amount]"
      super[ConsoleLogger].log(msg)
      super[TimestampLogger].log(msg)
      super[ShortLogger].log(msg)
    } else {
      super.withdrawal(amount)
    }
  }
}

object SuperGuardedAccount {
  // The companion object
  def apply(initialBalance: Double) =
    new SuperGuardedAccount(initialBalance)
}