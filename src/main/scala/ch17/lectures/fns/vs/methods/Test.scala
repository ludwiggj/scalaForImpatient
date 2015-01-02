package ch17.lectures.fns.vs.methods

class Test {
  def m1(x: Int) = x + 3
  val f1 = (x: Int) => x + 3
  val f2 : (Int) => Int = m1
  val f3 = m1 _
}