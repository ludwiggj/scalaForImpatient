import ch10.lectures.sec07.finance.GuardedAccount

// Following does not work (run time error)...
val a = new GuardedAccount(250.0)

a.withdrawal(300)
a.withdrawal(30)
a