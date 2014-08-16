package ch10.lectures.sec06

import ch10.lectures.sec02.Logger

trait ConsoleLogger extends Logger {
  override def log(msg: String) {
    println("<ConsoleLogger>" + msg)
  }
}