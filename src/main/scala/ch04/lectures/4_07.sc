import scala.language.postfixOps

(1, 3.14, "Fred")

val t = (1, 3.14, "Fred")

val second = t._2
val first = t _1

val (first, second, third) = t

val (first, second, _) = t

"New York".partition(_.isUpper)