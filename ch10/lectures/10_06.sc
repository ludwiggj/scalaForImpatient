import ch10.sec06.finance.GuardedAccount
import ch10.sec06.{ConsoleLogger, TimestampLogger}
val a = new GuardedAccount(250.0) with ConsoleLogger

a.withdrawal(300)
a.withdrawal(30)
a

val b = new GuardedAccount(250.0) with ConsoleLogger with TimestampLogger

b.withdrawal(300)
b.withdrawal(30)
b

// Following does not work (run time error)...
val c = new GuardedAccount(250.0) with TimestampLogger with ConsoleLogger

c.withdrawal(300)
c.withdrawal(30)
c

// Neither does this (compiler error)...
// val d = new GuardedAccount(250.0) with TimestampLogger