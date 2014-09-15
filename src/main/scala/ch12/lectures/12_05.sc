// Higher order functions

import scala.math.BigDecimal

val x = 1 to 9




val y = 0.1 to 0.9 by 0.1

val z = (1 to 9) map { x => BigDecimal(0.1 * x).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble }

(1 to 9).map("*" * _).foreach(println _)








(1 to 9) filter { _ % 2 == 0 }

(1 to 9).reduceLeft(_ * _)

"Mary had a little lamb her fleece was white as snow".split(" ").sortWith(_.length < _.length)
