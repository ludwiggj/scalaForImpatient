//2. Write a class BankAccount with methods deposit and withdraw, and a read-only
//   property balance.

class BankAccount() {
  private var privateBalance = 0

  def this(balance: Int) {
    this()
    this.privateBalance = balance
  }
  def balance = privateBalance
  def deposit(amount: Int) = {
    privateBalance += amount
  }
  def withdraw(amount: Int) = {
    val allowed = privateBalance >= amount
    if (allowed) {
      privateBalance -= amount
    }
    allowed
  }
}

new BankAccount().balance
//new BankAccount.balance  // Not allowed
val x = new BankAccount
x.balance

val y = new BankAccount(20)

y.balance
// This is ok
y deposit(20)
// This isn't (!)
//y deposit 20

y.balance
y.withdraw(30)
y.balance
y.withdraw(20)

y.balance