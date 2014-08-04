import ch10.sec04.{FileLogger, GuardedAccount, ConsoleLogger}
val a  = GuardedAccount(250.0)
a.withdrawal(300)
a.withdrawal(30)
a

val b = new GuardedAccount(250.0) with ConsoleLogger

b.withdrawal(300)
b.withdrawal(30)
b

val c = new GuardedAccount(250.0) with FileLogger


c.withdrawal(300)
c.withdrawal(30)
c


