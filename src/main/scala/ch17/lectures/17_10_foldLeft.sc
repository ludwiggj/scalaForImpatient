import ch17.lectures.sec10.{AccumulatorSubtractor, Accumulator}
abstract class Item {
  def price: BigDecimal
  def description: String
  override def toString = s"$description $price"
}

class SimpleItem(val price: BigDecimal, val description: String) extends Item
// Definition of foldLeft...

// trait LinearSeqOptimized[+A, +Repr <: scala.collection.LinearSeqOptimized[A, Repr]]
//   extends scala.AnyRef with scala.collection.LinearSeqLike[A, Repr] {
// this : Repr =>
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

// Let's analyse an interesting case:

//   items.foldLeft[Accumulator]( ... )(accumulate(_, _))

// A is SimpleItem, B is Accumulator

// Signature of fold operator, op, is (op (B, A) => B):
//                                         +  +     -

// 1. As AccumulatorSubtractor <: Accumulator,
//    op(AccumulatorSubtractor, SimpleItem) <: op(Accumulator, SimpleItem)

// 2. op is also 2nd input parameter to foldLeft, so must be contra-variant.

// 3. Thus op can have signature (B, A) => B; (Accumulator, SimpleItem) => Accumulator
//    or any supertype of that function

def accumulate(acc: Accumulator, item: Item): Accumulator = { acc + Accumulator(item.price) }
def subtraculate(acc: AccumulatorSubtractor, item: Item): AccumulatorSubtractor = { acc - Accumulator(item.price) }

// Remember, B is Accumulator...
items.foldLeft[Accumulator](Accumulator(0))(accumulate(_, _))

// In following case, subtraculate has type mismatch on 1st parameter
items.foldLeft[Accumulator](Accumulator(0))(subtraculate(_, _))

// Now try B as AccumulatorSubtractor...

// Rule 3. becomes (B, A) => B; (AccumulatorSubtractor, SimpleItem) => AccumulatorSubtractor
// or any supertype of that function

// Error here is that accumulate produces an Accumulator, compiler is expecting AccumulatorSubtractor
// NOTE: Not sure how this fits in with result of op method being -B (!)

// items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(accumulate(_, _))

// So let's define new function based on accumulate that returns an AccumulatorSubtractor

def accumulate2(acc: Accumulator, item: Item): AccumulatorSubtractor = { AccumulatorSubtractor(acc.total) + Accumulator(item.price) }

items.foldLeft[AccumulatorSubtractor](AccumulatorSubtractor(0))(accumulate2(_, _))

// So the way I'm thinking of this at the moment is...

//  override def foldLeft[B](z : B)(op (B, A) => B) : B
//                               -      +  +     -    +

// op is an argument to function, so has to be co-variant, but the signature of op specifies how to work out
// which op's are subtypes and supertypes of each other (I think this equates to the variance flipping)

// Does same thing apply to initial value (z) ?
// Applying similar "rule" the two -'s cancel out...

// The rest...

//items.foldLeft[AccumulatorSubtractor](Accumulator(0))(accumulate(_, _))
//items.foldLeft[AccumulatorSubtractor](Accumulator(0))(subtraculate(_, _))

//items.foldLeft(AccumulatorSubtractor(6))(accumulate(_, _))
//items.foldLeft[Accumulator](AccumulatorSubtractor(6))(accumulate(_, _))
//items.foldLeft(AccumulatorSubtractor(6))(subtraculate(_, _))
//items.foldLeft[Accumulator](AccumulatorSubtractor(6))(subtraculate(_, _))
// TRY AGAIN...


//-------------------------------------
/*
// Basic ones first
items.foldLeft(Accumulator(0))(accumulate(_, _))
items.foldLeft(AccumulatorSubtractor(6))(subtraculate(_, _))

// Let's play with variance of first argument (initial value) which is contra-variant...

// This is operating in opposite way to what I'm expecting :(
// Case (1) B is Accumulator, AccumulatorSubtractor shouldn't be allowed
// as it's a subclass of Accumulator, but it is allowed!
items.foldLeft[Accumulator](AccumulatorSubtractor(6))(accumulate(_, _))

// Case (2) B is AccumulatorSubtractor, Accumulator should be allowed
// as it's a superclass of Accumulator, but is isn't!

// Error:(30, 51) type mismatch;
// found   : ch17.lectures.sec10.Accumulator
// required: ch17.lectures.sec10.AccumulatorSubtractor

// items.foldLeft[AccumulatorSubtractor](Accumulator(6))(accumulate(_, _))

// Let's look at second argument, op i.e. the operator

// Remember:
//
// override def foldLeft[B](z : B)(op (B, A) => B) : B
//                              -      +  +     -    +
// NOTE: AccumulatorSubtractor <- Accumulator

// The following one works because operator has covariant parameters

// Hmm...

items.foldLeft[Accumulator](Accumulator(0))(subtraculate(_, _))


// Error:(28, 59) type mismatch;
// found   : ch17.lectures.sec10.Accumulator
// required: ch17.lectures.sec10.AccumulatorSubtractor

items.foldLeft(AccumulatorSubtractor(6))(accumulate(_, _))

*/