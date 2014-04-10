import sec02.Account

class Account(var balance: Double)

val account = new Account(1000.0)
val amount = 100.0
account.synchronized { account.balance += amount }

def printAny(x: Any) { println(x) }
def printUnit(x: Unit) { println(x) }
printAny("Hello")  // Prints Hello
printUnit("Hello") // Prints ()



