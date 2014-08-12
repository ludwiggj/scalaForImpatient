import ch10.sec06.finance.GuardedAccount
import ch10.sec10.FileLogger

val a = new GuardedAccount(250.0) with FileLogger

a.withdrawal(300)
a.withdrawal(30)
a