package ch17.lectures.sec10

trait Totaller {
  var total: BigDecimal
  override def toString = total.toString()
}

trait Adder extends Totaller {
  def +(other: Totaller): this.type = {
    total += other.total
    this
  }
}

trait Multiplier extends Totaller {
  def *(other: Totaller): this.type = {
    total *= other.total
    this
  }
}

class Acc(var total: BigDecimal) extends Adder {}
object Acc { def apply(tot: BigDecimal) = new Acc(tot) }

class Prod(var total: BigDecimal) extends Multiplier {}
object Prod { def apply(tot: BigDecimal) = new Prod(tot) }

// NOTE: AccProd extends Acc rather than Adder for demonstration's sake
class AccProd(total: BigDecimal) extends Acc(total) with Multiplier {}
object AccProd { def apply(tot: BigDecimal) = new AccProd(tot) }

object Main extends App {
  println(Acc(1) + Acc(17))
  println(Acc(1) + Acc(17) + Acc(12))
  println(Prod(1) * Prod(17))
  println(Prod(1) * Prod(17) * Prod(12))

  println((AccProd(4) * AccProd(5) + AccProd(6)) * AccProd(45))
}