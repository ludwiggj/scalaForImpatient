import ch10.sec03.{GuardedAccount, Account}

val a = Account(250.0)
a.withdrawal(300)
a

val b  = GuardedAccount(250.0)
b.withdrawal(300)
b.withdrawal(30)
b