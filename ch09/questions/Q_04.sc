//4. Write a Scala program that reads a text file containing only floating-point
//   numbers. Print the sum, average, maximum, and minimum of the numbers
//   in the file.

import scala.io.Source

val source = Source.fromFile("./ch09/questions/04_floats.txt", "UTF-8")

// Split on whitespace (including new lines)
val tokens = source.mkString.split("\\s+")

val numbers = for (w <- tokens) yield BigDecimal(w)

println("Sum: " + numbers.sum)
println("Min: " + numbers.min)
println("Max: " + numbers.max)
println("Average: " + numbers.sum/numbers.size)