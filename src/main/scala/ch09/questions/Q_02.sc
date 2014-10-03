//2. Write a Scala program that reads a file with tabs, replaces each tab with spaces
//   so that tab stops are at n-column boundaries, and writes the result to the
//   same file.

import java.io.PrintWriter
import scala.io.Source
import misc.Constants.FILE_ROOT

def fillToNextMultipleOfN(in: String, n: Int): String = {
  if (n <= 0) in else {
    in.padTo((in.size/n + 1) * n, '-')
  }
}
val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/questions/02_tabbedTextIn.txt", "UTF-8")
val n = 14
val lineIterator = source.getLines
val tokenisedLines = for (l <- lineIterator) yield l.split("\\t")
val spacedLines = for (line <- tokenisedLines)
  yield (line.dropRight(1) map (fillToNextMultipleOfN(_, n))) ++ line.takeRight(1)

val out = new PrintWriter(s"$FILE_ROOT/src/main/scala/ch09/questions/02_tabbedTextOut.txt")
for (spacedLine <- spacedLines) out.println(spacedLine.mkString)

source.close

out.close