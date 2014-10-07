import scala.collection.immutable.{TreeMap, SortedMap}

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

// Custom Ordering of Tree Map;
// taken from http://java.dzone.com/articles/custom-ordering-scala-treemap

// TreeMap with default ordering (ascending alphabetical order)
val dtm = TreeMap( "bc" -> 2, "a" -> 1, "def" -> 3 )

// Descending order of strings length
// Need an Ordering type.

object VarNameOrdering extends Ordering[String] {
  def compare(a:String, b:String) = b.length compare a.length
}
val tm1 = TreeMap( "a" -> 1, "bc" -> 2, "def" -> 3 )( VarNameOrdering )

// Stays ordered when add new entry
val tm2 = tm1 + ( "food" -> 4 )

// "However, a word of caution, one needs to be careful and
// remember that maps are usually implemented as hashes."

// Hmm, result of following is surprising!
val tm3 = tm2 + ( "z" -> 5 )

// Gives...
// tm3:... = Map(food -> 4, def -> 3, bc -> 2, z -> 5)
// what happened to a -> 1 ?

tm3.size

// Believe the issue here is that we are treating two non-identical
// keys as being equivalent i.e. "a" and "z" are the same length

// The issue doesn't happen for the standard map
val dtm1 = dtm + ( "z" -> 1 ) + ( "salad" -> 5)

// Another way to sort a map is just to get access to the keys and sort

dtm1.keys.toList

dtm1.keys.toList.sortWith ( _.length > _.length )

dtm1.keys.toList.sortWith ( _.length > _.length ).map( k => ( dtm1.get(k).get ))
dtm1.keys.toList.sortWith ( _.length > _.length ).map( dtm1.get(_).get )

dtm1.keys.toList.sortWith ( _.length > _.length ).map( k => ( k, dtm1.get(k).get ))