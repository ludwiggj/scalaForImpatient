// Function with variable number of arguments
def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}
val s = sum(1, 4, 9, 16, 25)
println(s)
// Cast the sequence so each element is used as an argument
val s1 = sum(Seq(1, 2, 3): _*)
val s2 = sum(1 to 5: _*)
println(s2)
def recursiveSum(args: Int*) : Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail : _*)
}
println(recursiveSum(1, 4, 9, 16, 25))
import java.text.MessageFormat
val str = MessageFormat.format(
  "The answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])
println(str)