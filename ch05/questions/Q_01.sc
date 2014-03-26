//1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
//Methods,” on page 51 so that it doesn’t turn negative at Int.MaxValue.

class Counter {
  private var value = Int.MaxValue - 1
  def increment() { if (value < Int.MaxValue) value += 1 else value = 0 }
  def current() = value
}

val myCounter = new Counter
myCounter.current
myCounter.increment
myCounter.current
myCounter.increment
myCounter.current
myCounter.increment
myCounter.current