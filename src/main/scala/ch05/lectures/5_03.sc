class Message {
  val timeStamp = new java.util.Date
}

val msg = new Message
msg.timeStamp

class Counter {
  private var value = 0
  def increment() { value += 1 }
  def current = value // No () in declaration
}

val myCounter = new Counter
myCounter.current
myCounter.increment()
myCounter.current