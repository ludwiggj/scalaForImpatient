package ch10.sec04

import scala.util.logging.Logged

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}
