//5. Write a Scala program that writes the powers of 2 and their reciprocals to a
//   file, with the exponent ranging from 0 to 20. Line up the columns:
//   1 1
//   2 0.5
//   4 0.25
//   ... ...

import java.io._
import misc.Constants.FILE_ROOT
import scala.math.pow

val out = new PrintWriter(s"$FILE_ROOT/src/main/scala/ch09/questions/05_powers.txt")

for (i <- 0 to 20) {
  val value = pow(2, i)
  out.print("%8d %10.8f\n".format(value.toInt, 1.0 / value))
}
out.close()