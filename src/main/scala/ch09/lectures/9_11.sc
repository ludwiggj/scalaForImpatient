val numitemPattern = "([0-9]+) ([a-z]+)".r

val numitemPattern(num, item) = "99 bottles"


for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bottles, 98 bottles"))
println(item + ": " + num)

// Throws scala.MatchError is no match
val numitemPattern(num, item) = "99..."