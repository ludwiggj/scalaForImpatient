package ch17.lectures.sec10

class Accumulator {
  var total = BigDecimal(0)

  def this(total: BigDecimal) {
    this()
    this.total = total
  }

  def +(other: Accumulator) = Accumulator(total + other.total)

  override def toString = total.toString()
}

object Accumulator {
  def apply(n: BigDecimal) = new Accumulator(n)
}