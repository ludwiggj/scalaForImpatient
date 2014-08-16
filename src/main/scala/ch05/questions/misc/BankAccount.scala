package ch05.questions.misc

import scala.language.postfixOps
import scala.Predef._

class BankAccount(private var privateBalance: Int = 0) {
  def balance = s"Bal $privateBalance"

  def balanceAlt() = {
    s"Bal $privateBalance"
  }

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

object Main extends App {
  println(new BankAccount().balance)
  val x = new BankAccount
  println(x.balance)

  val y = new BankAccount(20)
  // y balance                 // This isn't OK
  println(y balance)           // But this is(!)
  println(y balanceAlt)
  y deposit (10)
  println(y balance)
  y.deposit(15)
  println(y balance)
  y deposit 5
  println(y balance)
  println(y withdraw (30))
  println(y balance)
  println(y withdraw 30)
  println(y balance)
}
