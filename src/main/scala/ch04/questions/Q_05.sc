//5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
//Scala API.

import scala.collection.JavaConversions.mapAsScalaMap
import collection.SortedMap
val f = new java.io.File("./src/main/scala/ch04/questions/myFile.txt")
val in = new java.util.Scanner(f)

// Adapt a Java treemap so that the keys are automatically sorted

// Using SortedMap results in type mismatch error
// var counts: scala.collection.SortedMap[String, Int] = new java.util.TreeMap[String, Int](Ordering.String)

// This works but collection is not sorted on key
// var counts: collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int](Ordering.String)
var counts: SortedMap[String, Int] =
    SortedMap[String, Int]() ++ new java.util.TreeMap[String,Int]

while (in.hasNext()) {
  val word = in.next()
  print(">" + word + "<")
  counts = counts + (word -> (counts.getOrElse(word, 0) + 1))
}

for ((k, v) <- counts) println(k, v)