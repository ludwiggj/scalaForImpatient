import java.io._
import misc.Constants.FILE_ROOT
val out = new PrintWriter(s"$FILE_ROOT/src/main/scala/ch09/lectures/numbers.txt")
for (i <- 1 to 10) out.printf("%6d %10.6f\n", i.asInstanceOf[AnyRef], (2.0 / i).asInstanceOf[AnyRef])
for (i <- 1 to 10) out.print("%6d %10.6f\n".format(i, 1.0 / i))
out.close()

for (i <- 1 to 10) printf("%6d %10.6f\n", i, 2.0 / i)