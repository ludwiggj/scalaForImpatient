import scala.collection.immutable.SortedMap

def showMap(s: Map[String, String]) {
  for ((x, y) <- s) {
    print(s"($x -> $y) ")
  }
  println()
  val ssIter = s.iterator
  while (ssIter.hasNext) {
    print(s"${ssIter.next()} ")
  }
}

showMap(SortedMap("z" -> "zebra", "c" -> "cat", "t" -> "tiger"))


showMap(Map("z" -> "zebra", "c" -> "cat", "t" -> "tiger"))

