abstract class Item {
  def price: BigDecimal
  def description: String
  override def toString = s"$description $price"
}

class SimpleItem(val price: BigDecimal, val description: String) extends Item

val football = new SimpleItem(2.5, "Football")
val boot = new SimpleItem(13.3, "Golden Boot")

val items: List[SimpleItem] = List(football, boot)
val price = items.foldLeft[BigDecimal](BigDecimal(0))(_ + _.price)


// Definition of foldLeft...

// trait LinearSeqOptimized[+A, +Repr <: scala.collection.LinearSeqOptimized[A, Repr]]
//   extends scala.AnyRef with scala.collection.LinearSeqLike[A, Repr] {
// this : Repr =>
// ...
//  override def foldLeft[B](z : B)(op (B, A) => B) : B
//                               -      +  +     -    +

// Tried...

// val ref = new AnyRef
// ref.hashCode()
// val anotherPrice = items.foldLeft[BigDecimal](ref)(_ + "|" + _.price.toString()).toString

object Accumulator {
  def apply(n: BigDecimal) = new Accumulator(n)
}

class Accumulator {
  var total = BigDecimal(0)

  def this(total: BigDecimal) {
    this()
    this.total = total
  }

  def +(other: Accumulator) = Accumulator(total + other.total)

  override def toString = total.toString()
}

Accumulator(6) + Accumulator(12)

def accumulate(acc: Accumulator, item: Item): Accumulator = {
  acc + Accumulator(item.price)
}

items.foldLeft[Accumulator](Accumulator(0))(accumulate(_, _))