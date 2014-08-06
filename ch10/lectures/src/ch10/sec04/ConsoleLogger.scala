package ch10.sec04

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}
