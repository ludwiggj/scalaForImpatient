//7. Write a Scala program that reads a text file and prints all tokens in the file
//   that are not floating-point numbers. Use a regular expression.

import scala.io.Source
import misc.Constants.FILE_ROOT

val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/questions/07_textWithFloats.txt", "UTF-8")

// Split on whitespace (including new lines)
val tokens = source.mkString.split("\\s+")

val fpNumber = """[0-9]*\.[0-9]+""".r
tokens.filter {
  candidate => (fpNumber findFirstIn candidate).isEmpty
}.mkString(" ")