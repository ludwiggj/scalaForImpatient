package ch10.lectures.sec04

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}
