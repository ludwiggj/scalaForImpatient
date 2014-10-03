//6. Make a regular expression searching for quoted strings "like this, maybe with
//   \" or \\" in a Java or C++ program. Write a Scala program that prints out all
//   such strings in a source file.

import scala.io.Source
import misc.Constants.FILE_ROOT

val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/questions/03_words.txt", "UTF-8")

val contents = source.mkString

val quotedString = """\"[^\"]*\"""".r
for (matchString <- quotedString.findAllIn(contents))
  println(matchString)

source.close