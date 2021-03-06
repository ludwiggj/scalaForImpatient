class Counter {
  private var value = 0
  def increment() { value += 1 }

  def isLess(other : Counter) = value < other.value
    // Can access private field of other object
}

class Counter1 {
  private[this] var value = 0
  def increment() { value += 1 }

  def isLess(other : Counter1) = value < other.value
    // Can't access private[this] field of other object
}