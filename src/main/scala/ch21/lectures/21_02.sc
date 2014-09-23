import java.io.File
import scala.io.Source

// We want this...
// val contents = new File("./src/main/scala/ch09/lectures/mary.txt").read

class RichFile(val from: File) {
  def read = Source.fromFile(from.getPath).mkString
}

implicit def file2RichFile(from: File) = new RichFile(from)

val contents = new File("./src/main/scala/ch09/lectures/mary.txt").read












