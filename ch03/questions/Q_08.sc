//8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on
//   page 34 using the drop method for dropping the index of the first match. Look
//   the method up in Scaladoc.

//Consider the following example. Given a sequence of integers, we want to remove
//all but the first negative number. A traditional sequential solution would set a
//flag when the first negative number is called, then remove all elements beyond.

//But wait—that’s actually not so good. It’s inefficient to remove variables from
//the front. We should start from the back after finding the first match.
//In Scala, your life can be easier. First, let’s use a for/yield loop to find all matching
//index values.
//Then we visit the indexes in reverse, except for indexes(0).

import scala.collection.mutable.ArrayBuffer
def removeAllButFirstNegative(a: ArrayBuffer[Int]) = {
  val indexes = (for (i <- 0 until a.length if a(i) < 0) yield i) drop 1
  for (j <- (indexes.reverse)) a.remove(j)
  a
}


removeAllButFirstNegative(ArrayBuffer(1, 2, -4, 5, -1, -20, 6))
removeAllButFirstNegative(ArrayBuffer(1, 2, 5, 6))