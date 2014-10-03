import scala.io.Source
import misc.Constants.FILE_ROOT

def readWord(iter: BufferedIterator[Char]) = {
  val builder = new StringBuilder
  while (iter.hasNext && !Character.isWhitespace(iter.head))
    builder += iter.next()
  builder
}

val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/lectures/mary.txt", "UTF-8")
val iter = source.buffered
while (iter.hasNext) {
  print(readWord(iter))
  if (iter.next == '\n') println() else print(",")
}
source.close()