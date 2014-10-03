//3. Write a Scala code snippet that reads a file and prints all words with more
//   than 12 characters to the console. Extra credit if you can do this in a single line.

import scala.io.Source
import misc.Constants.FILE_ROOT

/*
val source = Source.fromFile("./ch09/questions/03_words.txt", "UTF-8")
val contents = source.mkString
val wordOfAtLeast10Characters = """[A-Za-z]{10,}""".r
for (matchString <- wordOfAtLeast10Characters.findAllIn(contents))
  println(matchString)

source.close
*/
// In a single line...
"""[A-Za-z]{10,}""".r.findAllIn(Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/questions/03_words.txt", "UTF-8").mkString).foreach(println(_))