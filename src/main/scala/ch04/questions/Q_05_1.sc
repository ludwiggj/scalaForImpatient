//5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
//Scala API.

import misc.Constants.FILE_ROOT

// Apparently JavaConversions is now deprecated in favour of JavaConverters
import collection.JavaConverters._
import collection.SortedMap
val f = new java.io.File(s"$FILE_ROOT/src/main/scala/ch04/questions/myFile.txt")
val in = new java.util.Scanner(f)

var counts: SortedMap[String, Int] =
    SortedMap[String, Int]() ++ new java.util.TreeMap[String,Int].asScala



while (in.hasNext()) {
  val word = in.next()
  print(">" + word + "<")
  counts = counts + (word -> (counts.getOrElse(word, 0) + 1))
}

for ((k, v) <- counts) println(k, v)