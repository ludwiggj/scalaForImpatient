package ch10.sec05

import ch10.sec04.GuardedAccount

object Logger1 extends App {

  val a = new GuardedAccount(250.0) with ConsoleLogger with TimestampLogger with ShortLogger

  a.withdrawal(300)
  a.withdrawal(30)
}