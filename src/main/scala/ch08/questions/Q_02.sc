// 2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount
// that earns interest every month (when a method earnMonthlyInterest is called)
// and has three free deposits or withdrawals every month. Reset the transaction
// account in the earnMonthlyInterest method.

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount;
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
}

class SavingsAccount(initialBalance: Double, monthlyInterestAsPercentage: Double) extends BankAccount(initialBalance) {
  private var txCount = 0
  private val interestMultiplier = monthlyInterestAsPercentage / 100
  private final val TX_LIMIT_REACHED = "Transaction limit reached"

  override def deposit(amount: Double) = {
    if (txLimitReached()) throw new RuntimeException(TX_LIMIT_REACHED)
    txCount += 1
    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    if (txLimitReached()) throw new RuntimeException(TX_LIMIT_REACHED)
    txCount += 1
    super.withdraw(amount)
  }

  def earnMonthlyInterest() = {
    txCount = 0
    super.deposit(super.withdraw(0) * interestMultiplier);
    super.withdraw(0)
  }

  def txLimitReached() = txCount == 3
}

val x = new SavingsAccount(100, 10)

x.deposit(50)
x.deposit(60)
x.deposit(70)
x.deposit(80)

x.earnMonthlyInterest()
x.withdraw(80)
x.withdraw(70)
x.withdraw(60)
x.earnMonthlyInterest()
x.withdraw(50)