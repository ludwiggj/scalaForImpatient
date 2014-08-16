//1. Extend the following BankAccount class to a CheckingAccount class that
// charges $1 for every deposit and withdrawal.

//class BankAccount(initialBalance: Double) {
//private var balance = initialBalance
//def deposit(amount: Double) = { balance += amount; balance }
//def withdraw(amount: Double) = { balance -= amount; balance }
//}

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount; balance
  }

  def withdraw(amount: Double) = {
    balance -= amount; balance
  }
}
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double) = {
      super.deposit(amount-1)
  }

  override def withdraw(amount: Double) = {
      super.withdraw(amount+1)
  }
}

val x = new BankAccount(12.0)

x.deposit(20)
x.withdraw(15)

val x = new CheckingAccount(12.0)

x.deposit(20)
x.withdraw(15)