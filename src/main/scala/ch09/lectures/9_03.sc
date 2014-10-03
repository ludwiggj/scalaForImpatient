// Type these commands into the REPL, or run scala script.scala

import scala.io.Source
import misc.Constants.FILE_ROOT

val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/lectures/values.txt", "UTF-8")

// Split on whitespace (including new lines)
val tokens = source.mkString.split("\\s+")

val numbers = for (w <- tokens) yield w.toDouble

println("Sum: " + numbers.sum)