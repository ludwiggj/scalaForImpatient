package ch17.lectures.sec10

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

object Main1 extends App {
  Accumulator(6) + Accumulator(12)
  AccumulatorSubtractor(6) - Accumulator(12)

  val football = new SimpleItem(2.5, "Football")
  val boot = new SimpleItem(13.3, "Golden Boot")

  val items: List[SimpleItem] = List(football, boot)
  val price = items.foldLeft[BigDecimal](BigDecimal(0))(_ + _.price)

  //  override def foldLeft[B](z : B)(op (B, A) => B) : B
  //                               -      +  +     -    +

  // Let's analyse an interesting case. Given:
  def accumulate(acc: Accumulator, item: Item): Accumulator = {
    acc + Accumulator(item.price)
  }

  def subtraculate(acc: AccumulatorSubtractor, item: Item): AccumulatorSubtractor = {
    acc - Accumulator(item.price)
  }

  // (1) items.foldLeft[Accumulator](Accumulator(0))(op)

  // Remember, items is a List[SimpleItem], so A is SimpleItem and B is Accumulator

  // Signature of fold operator, op, is (op (B, A) => B):
  //                                         +  +     -

  //                                            <--------------- op --------------------->
  // items.foldLeft[Accumulator](Accumulator(0))((Accumulator, SimpleItem) => Accumulator)
  //                                  -                             -

  // Given AccumulatorSubtractor <: Accumulator
  // and              SimpleItem <: Item

  // <---------- accumulate ---------->    <-------------- op -------------------->
  // (Accumulator, Item) => Accumulator <: (Accumulator, SimpleItem) => Accumulator

  println(items.foldLeft[Accumulator](Accumulator(0))(accumulate(_, _)))

  // This is also ok
  println(items.foldLeft[Accumulator](AccumulatorSubtractor(6))(accumulate(_, _)))

  // What about subtraculate?

  // <------------------- subtraculate ------------------->           <-------------- op -------------------->
  // (AccumulatorSubtractor, Item) => AccumulatorSubtractor IS NOT <: (Accumulator, SimpleItem) => Accumulator

  // due to the 1st parameter

  // In following cases, subtraculate has type mismatch on 1st parameter
  // items.foldLeft[Accumulator](Accumulator(0))(subtraculate(_, _))
  // items.foldLeft[Accumulator](AccumulatorSubtractor(6))(subtraculate(_, _))

  // Now let's try...

  // (2) items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(op)

  //                                                                <-------------------------- op ------------------------------>
  // items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))((AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor)
  // NOTE:
  // <---------- accumulate ---------->           <------------------------- op ----------------------------->
  // (Accumulator, Item) => Accumulator IS NOT <: (AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor

  // due to the return type...

  // Error here is that accumulate produces an Accumulator, compiler is expecting AccumulatorSubtractor

  // items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(accumulate(_, _))

  // BUT...

  // <------------- new accumulate ------------->    <------------------------- op ----------------------------->
  // (Accumulator, Item) => AccumulatorSubtractor <: (AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor

  // So let's define new function "newAccumulate" based on accumulate that returns an AccumulatorSubtractor

  def newAccumulate(acc: Accumulator, item: Item): AccumulatorSubtractor = {
    AccumulatorSubtractor(acc.total) + Accumulator(item.price)
  }

  // So this now works...
  println(items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(newAccumulate(_, _)))

  // BUT following call doesn't...
  // items.foldLeft[AccumulatorSubtractor](Accumulator(0))(newAccumulate(_, _))

  // We could potentially fix this a different way....

  // <---------- accumulate ---------->    <------------------ new op ---------------------->
  // (Accumulator, Item) => Accumulator <: (AccumulatorSubtractor, SimpleItem) => Accumulator

  // but op is defined as (B, A) => B, so we can't have different types for B.

  // What about subtraculate?

  // <------------------- subtraculate ------------------->    <------------------------- op ----------------------------->
  // (AccumulatorSubtractor, Item) => AccumulatorSubtractor <: (AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor
  println(items.foldLeft(AccumulatorSubtractor(6))(subtraculate(_, _)))
}