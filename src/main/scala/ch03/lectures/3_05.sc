import scala.collection.mutable.ArrayBuffer

Array(1, 7, 2, 9).sum

ArrayBuffer("Mary", "had", "a", "little", "lamb").max

val b = ArrayBuffer(1, 7, 2, 9)
val bSorted = b.sorted
// scala.util.Sorting.quickSort(b) - not allowed
val a = Array(1, 7, 2, 9)
// a = a.sorted // Not allowed
val aSorted = a.sorted
a.mkString(" and ")
scala.util.Sorting.quickSort(a) // Array is mutable
a.mkString(" and ")
a.mkString("<", ",", ">")
a.toString
b.toString