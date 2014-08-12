import ch10.sec11.finance.GuardedAccount
import ch10.sec11.{LazyFileLogger, FileLogger}


// Wrong version
/*
val a = new GuardedAccount(250.0) with FileLogger {
  val filename = "myapp.log"
}
*/
val a = new {
  val filename = "myapp1.log"
} with ch10.sec06.finance.GuardedAccount(250.0) with FileLogger

a.withdrawal(300)
a.withdrawal(30)
a

val b = new GuardedAccount(250.0) with FileLogger

b.withdrawal(300)
b.withdrawal(30)
b

val c = new ch10.sec06.finance.GuardedAccount(250.0) with LazyFileLogger {
  val filename = "myapp2.log"
}

c.withdrawal(450)
c.withdrawal(45)
c