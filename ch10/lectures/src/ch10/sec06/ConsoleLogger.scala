package ch10.sec06

import ch10.sec02.Logger

trait ConsoleLogger extends Logger {
  override def log(msg: String) {
    println("<ConsoleLogger>" + msg)
  }
}