import java.io.File
import scala.io.Source
import scala.language.implicitConversions
import misc.Constants.FILE_ROOT

// We want this...
// val contents = new File("./src/main/scala/ch09/lectures/mary.txt").read
class RichFile(val from: File) {
  def read = Source.fromFile(from.getPath).mkString
}

implicit def file2RichFile(from: File) = new RichFile(from)
// File automatically converted to RichFile via an implicit, as
// read method does not exist on File class
val contents = new File(s"$FILE_ROOT/src/main/scala/ch09/lectures/mary.txt").read