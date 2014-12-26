package ch17.lectures.sec10

abstract class Item {
  def price: BigDecimal
  def description: String
  override def toString = s"$description $price"
}

class SimpleItem(val price: BigDecimal, val description: String) extends Item

object ExperimentMain extends App {

  println(Acc(6) + Acc(12))
  println(Prod(6) * Prod(12))
  println(AccProd(6) + AccProd(12))
  println(AccProd(6) * AccProd(12))

  val football = new SimpleItem(2.5, "Football")
  val boot = new SimpleItem(13.3, "Golden Boot")
  val items: List[SimpleItem] = List(football, boot)
  val price = items.foldLeft[BigDecimal](BigDecimal(0))(_ + _.price)

  // Class definitions...

  //  Acc <:      Adder <: Totaller
  // Prod <: Multiplier <: Totaller

  // and...

  // AccProd <: Acc
  //         <: Multiplier

  // and...

  // SimpleItem <: Item

  // Definition of foldLeft...

  // trait LinearSeqOptimized[+A, +Repr <: scala.collection.LinearSeqOptimized[A, Repr]]
  //      extends scala.AnyRef with scala.collection.LinearSeqLike[A, Repr] {
  // ...
  //  override def foldLeft[B](z : B)(op (B, A) => B) : B
  //                               -      +  +     -    + // These are annotated in book, not in source code

  def sumUpAccToAcc: (Acc, Item) => Acc =
    (acc, item) => {
      acc + Acc(item.price)
    }

  def sumUpAccProdToAccProd: (AccProd, Item) => AccProd =
    (acc, item) => {
      acc + AccProd(item.price)
    }

  def sumUpAccToAccProd: (Acc, Item) => AccProd =
    (acc, item) => {
      AccProd(acc.total) + AccProd(item.price)
    }

  def sumUpAdderToAccProd: (Adder, Item) => AccProd =
      (acc, item) => {
        AccProd(acc.total) + AccProd(item.price)
      }

  def sumTheList(start: Acc, sum: (Acc, Item) => Acc): BigDecimal = {
    items.foldLeft(start)(sum).total
  }

  println(sumTheList(Acc(0), sumUpAccToAcc))
  // println(sumTheList(AccProd(0), sumUpAccProdToAccProd))

  def sumTheList2(start: AccProd, sum: (AccProd, Item) => AccProd): BigDecimal = {
    items.foldLeft(start)(sum).total
  }

  println(sumTheList2(AccProd(0), sumUpAccProdToAccProd))
  // println(sumTheList2(Acc(0), sumUpAccToAcc))
  println(sumTheList2(AccProd(0), sumUpAccToAccProd))

  def sumTheList3(start: Adder, sum: (Adder, Item) => Adder): BigDecimal = {
      items.foldLeft(start)(sum).total
  }

  // println(sumTheList3(AccProd(0), sumUpAccProdToAccProd))
  // println(sumTheList3(Acc(0), sumUpAccToAcc))
  println(sumTheList3(Acc(0), sumUpAdderToAccProd))

  def sumTheList4(start: Acc, sum: (Acc, Item) => AccProd): BigDecimal = {
    items.foldLeft(start)(sum).total
  }

  println(sumTheList4(Acc(0), sumUpAdderToAccProd))
}