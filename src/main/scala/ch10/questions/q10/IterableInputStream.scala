package ch10.questions.q10

import java.io.{FileInputStream, InputStream}
import misc.Constants.FILE_ROOT
import scala.language.postfixOps

trait IterableInputStream extends InputStream with Iterable[Byte] {
  def iterator: Iterator[Byte] = new Iterator[Byte] {
    def hasNext: Boolean = available() > 0
    def next(): Byte = read() toByte
  }
}

object Main extends App {
  val stream = new FileInputStream(s"$FILE_ROOT/bob.txt") with IterableInputStream
  for (b <- stream) print(b.toChar)
  stream.close()
}