package ch10.lectures.stackable

trait Doubling extends IntQueue {
  abstract override def put(x: Int) {
    super.put(2 * x)
  }
}