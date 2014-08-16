package ch10.lectures.sec05

import ch10.lectures.sec04.finance.GuardedAccount
import ch10.lectures.sec04.ConsoleLogger

object ShortTimestampConsoleLogger extends App {

  val a = new GuardedAccount(250.0) with ConsoleLogger with TimestampLogger with ShortLogger

  a.withdrawal(300)
  a.withdrawal(30)
}