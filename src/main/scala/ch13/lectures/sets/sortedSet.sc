import scala.collection.immutable.SortedSet

def showSet(s: Set[Int]) {
  for (elem <- s) {
    print(s"$elem ")
  }
  println()
  val ssIter = s.iterator
  while (ssIter.hasNext) {
    print(s"${ssIter.next()} ")
  }
}
showSet(SortedSet(2, 4, 6, 8))
showSet(Set(2, 4, 6, 8))