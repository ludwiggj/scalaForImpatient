//7. Write a Scala program that reads a text file and prints all tokens in the file
//   that are not floating-point numbers. Use a regular expression.

import scala.io.Source

val source = Source.fromFile("./ch09/questions/07_textWithFloats.txt", "UTF-8")

// Split on whitespace (including new lines)
val tokens = source.mkString.split("\\s+")

val fpNumber = """[0-9]*\.[0-9]+""".r
tokens.filter {
  candidate => (fpNumber findFirstIn candidate).isEmpty
}