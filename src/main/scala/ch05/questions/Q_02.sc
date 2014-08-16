//2. Write a class BankAccount with methods deposit and withdraw, and a read-only
//   property balance.

// See BankAcount.scala for an improved version using primary constructor only...

import scala.language.postfixOps

class BankAccount() {
  private var privateBalance = 0

  def this(balance: Int) {
    this()
    this.privateBalance = balance
  }
  def balance = s"Bal $privateBalance"
  def balanceAlt() = { s"Bal $privateBalance" }
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

// y balance // not ok
println(y balance) // ok(!)
y.balance
y.balanceAlt
y deposit(10)
y.balance
y.deposit(15)
y.balance
y deposit 5
y.balance
y withdraw(30)
y.balance
y withdraw 30
y.balance