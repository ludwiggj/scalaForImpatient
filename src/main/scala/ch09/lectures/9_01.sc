import scala.io.Source

val homeDir = "./src/main/scala/ch09/lectures/"
val maryFile = homeDir + "mary.txt"
val source = Source.fromFile(maryFile, "UTF-8")
val lineIterator = source.getLines

for (l <- lineIterator)
  println(if (l.length <= 13) l else l.substring(0, 10) + "...")

source.close()

// Caution: The sources below aren't closed.

val lines = Source.fromFile(maryFile, "UTF-8").getLines.toArray

lines(0)
val contents = Source.fromFile(maryFile, "UTF-8").mkString