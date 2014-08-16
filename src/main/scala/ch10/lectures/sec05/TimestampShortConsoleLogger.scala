package ch10.lectures.sec05

import ch10.lectures.sec04.finance.GuardedAccount
import ch10.lectures.sec04.ConsoleLogger

object TimestampShortConsoleLogger extends App {

  val a = new GuardedAccount(250.0) with ConsoleLogger with ShortLogger with TimestampLogger

  a.withdrawal(300)
  a.withdrawal(30)
}