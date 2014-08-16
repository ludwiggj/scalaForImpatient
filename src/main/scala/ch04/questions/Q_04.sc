//Q4 Repeat the preceding exercise with a sorted map, so that the words are
//printed in sorted order.

val f = new java.io.File("./src/main/scala/ch04/questions/myFile.txt")
val in = new java.util.Scanner(f)

// Use an immutable map
var counts = scala.collection.immutable.SortedMap[String, Int]()
while (in.hasNext()) {
  val word = in.next()
  print(">" + word + "<")
  counts = counts + (word -> (counts.getOrElse(word, 0) + 1))

}

for ((k, v) <- counts) println(k, v)