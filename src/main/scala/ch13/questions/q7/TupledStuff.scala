package ch13.questions.q7

class TupledStuff {
  def doIt() = {

    val prices = List[Double](2.4, 5.67, 1.02)
    val quantities = List[Int](2, 5, 1)

    val sales = (prices zip quantities)

    println(sales)

    def multiplyWithParams(a: Double, b: Int) = a * b
    def multiplyTupleWithParams: ((Double, Int)) => Double = (multiplyWithParams _).tupled

    def multiply: (Double, Int) => Double = _ * _
    def multiplyTuple: ((Double, Int)) => Double = multiply.tupled

    println(sales map multiplyTupleWithParams)
    println(sales map multiplyTuple)
  }
}

object Main extends App {
  new TupledStuff().doIt()
}