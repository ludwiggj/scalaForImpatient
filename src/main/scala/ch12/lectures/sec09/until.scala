package ch12.lectures.sec09

object Main2 extends App {
  def until(condition: => Boolean)(block: => Unit) {
    if (! condition) {
      block
      until(condition)(block)
    }
  }

  var x = 10
  until (x == 0) {
    x -= 1
    println(x)
  }
}