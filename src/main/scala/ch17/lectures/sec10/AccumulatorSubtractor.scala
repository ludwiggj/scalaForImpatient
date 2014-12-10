package ch17.lectures.sec10

class AccumulatorSubtractor extends Accumulator {
  def this(total: BigDecimal) {
    this()
    this.total = total
  }

  // TODO I know there's a better way to do this as opposed to overriding, can't remember it at the moment...
  override def +(other: Accumulator) = AccumulatorSubtractor(total + other.total)

  def -(other: Accumulator) = AccumulatorSubtractor(total - other.total)
}

object AccumulatorSubtractor {
  def apply(n: BigDecimal) = new AccumulatorSubtractor(n)
}