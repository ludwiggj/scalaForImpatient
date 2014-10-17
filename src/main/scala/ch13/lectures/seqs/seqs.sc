// Operators for adding / removing elements

// Adding an element
List(1) :+ 3
2 +: List(2)

// Add two collections together
List(1) ++ List(2, 3)
List(1) ++: List(2, 3)

// Prepend element
1 :: List(2, 4, 8)

// Prepend collection
List(2, 4, 6) ::: List(1, 3, 5)

// Mutable operations
import scala.collection.mutable

val a = mutable.ListBuffer(1)
a += 2
a += (3, 4)
a ++= List(6, 8)

a -= 2
a -= (6, 8)
a --= List(9, 1)

// Other important methods
val l = List(16, 1, 2, 4, 8, 16, 1)
l.contains(4)
l.contains(5)

l.containsSlice(List(1, 4))
l.containsSlice(List(2, 4))

l.startsWith(List(2, 4))
l.startsWith(List(1, 2))

l.endsWith(List(1, 2))
l.endsWith(List(8, 16))

l.indexOf(-2)
l.indexOf(1)
l.lastIndexOf(1)
l.indexOfSlice(List(16, 1))
l.indexOfSlice(List(16, 0))
l.lastIndexOfSlice(List(16, 1))
l.indexWhere(_ > 7)
l.prefixLength(_ > 7)
l.segmentLength(_ > 7, 1)
l.segmentLength(_ > 7, 4)
l.padTo(10, -9)
List(1,1,1,1,1) intersect List(1,1)
List(1,1,1,1,1) diff List(1,1)
l.reverse
l.sorted
l.sortWith((a: Int, b: Int) => a > b)

val words = "The quick brown fox jumped over the lazy dog".split(' ')

// this works because scala.Ordering will implicitly provide an Ordering[Tuple2[Int, Char]]
words.sortBy(x => (x.length, x.head))

val phrase = List("madam", "i", "am", "adam")

phrase.permutations.mkString("\n")
phrase.combinations(2).mkString("\n")