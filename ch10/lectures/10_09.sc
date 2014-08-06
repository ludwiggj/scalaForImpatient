import ch10.sec04.ConsoleLogger
import ch10.sec09.finance.GuardedAccount
import ch10.sec09.ShortLogger

val a = new GuardedAccount(250.0)

a.withdrawal(300)
a.withdrawal(30)
a

val b = new ch10.sec04.finance.GuardedAccount(250.0) with ConsoleLogger with ShortLogger{
  val maxLength: Int = 20
}

b.withdrawal(300)
b.withdrawal(30)
b