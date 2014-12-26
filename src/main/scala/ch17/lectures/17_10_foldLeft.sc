import ch17.lectures.sec10.{AccumulatorSubtractor, Accumulator}

abstract class Item {
  def price: BigDecimal
  def description: String
  override def toString = s"$description $price"
}

class SimpleItem(val price: BigDecimal, val description: String) extends Item
// Definition of foldLeft...

// trait LinearSeqOptimized[+A, +Repr <: scala.collection.LinearSeqOptimized[A, Repr]]
//   extends scala.AnyRef with scala.collection.LinearSeqLike[A, Repr] ...
// ...
//  override def foldLeft[B](z : B)(op (B, A) => B) : B
//                               -      +  +     -    +

Accumulator(6) + Accumulator(12)
AccumulatorSubtractor(6) - Accumulator(12)

val football = new SimpleItem(2.5, "Football")
val boot = new SimpleItem(13.3, "Golden Boot")

val items: List[SimpleItem] = List(football, boot)
val price = items.foldLeft[BigDecimal](BigDecimal(0))(_ + _.price)

//  override def foldLeft[B](z : B)(op (B, A) => B) : B
//                               -      +  +     -    +

// Let's analyse an interesting case. Given:

def accumulate(acc: Accumulator, item: Item): Accumulator = { acc + Accumulator(item.price) }
def subtraculate(acc: AccumulatorSubtractor, item: Item): AccumulatorSubtractor = { acc - Accumulator(item.price) }

items.foldLeft[Accumulator](Accumulator(0))(accumulate(_, _))

// In the above, A is SimpleItem, B is Accumulator

// Signature of fold operator, op, is (op (B, A) => B):
//                                         +  +     -

// items.foldLeft[Accumulator](Accumulator(0))((Accumulator, SimpleItem) => Accumulator)
//                                  -               -             -              +

// Given AccumulatorSubtractor <: Accumulator
// and              SimpleItem <: Item

// NOTE:

// (Accumulator, Item) => Accumulator IS NOT <: (AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor
//                                    ------
// Due to the return types...
//
// BUT:
//
// (Accumulator, Item) => Accumulator IS <: (AccumulatorSubtractor, SimpleItem) => Accumulator

// In following case, subtraculate has type mismatch on 1st parameter
items.foldLeft[Accumulator](Accumulator(0))(subtraculate(_, _))

// Now let's try...

// items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))((AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor)

// Error here is that accumulate produces an Accumulator, compiler is expecting AccumulatorSubtractor

items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(accumulate(_, _))

// So let's define new function based on accumulate that returns an AccumulatorSubtractor

def accumulate2(acc: Accumulator, item: Item): AccumulatorSubtractor = { AccumulatorSubtractor(acc.total) + Accumulator(item.price) }

items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(accumulate2(_, _))
items.foldLeft[Accumulator](AccumulatorSubtractor(6))(accumulate(_, _))
items.foldLeft(AccumulatorSubtractor(6))(subtraculate(_, _))

// The following calls are not valid
items.foldLeft[AccumulatorSubtractor](Accumulator(0))(accumulate(_, _))
items.foldLeft[Accumulator](AccumulatorSubtractor(6))(subtraculate(_, _))