// Type these commands into the REPL, or run scala script.scala

import scala.io.Source

val source = Source.fromFile("./ch09/lectures/values.txt", "UTF-8")

// Split on whitespace (including new lines)
val tokens = source.mkString.split("\\s+")

val numbers = for (w <- tokens) yield w.toDouble

println("Sum: " + numbers.sum)