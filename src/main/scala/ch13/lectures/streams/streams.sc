def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

val tenOrMore = numsFrom(10)

tenOrMore.tail.tail.tail

val squares = numsFrom(1).map(x => x * x)
squares.tail
squares.tail
squares.tail.tail
squares.take(5)

val take5 = squares.take(5).force

take5.tail
take5.tail.tail
take5.tail.tail.tail
take5.tail.tail.tail.tail
take5.tail.tail.tail.tail.tail

squares.drop(5).take(5).force

import scala.io.Source
import misc.Constants.FILE_ROOT

val homeDir = s"$FILE_ROOT/src/main/scala/ch09/lectures/"
val maryFile = homeDir + "mary.txt"
val source = Source.fromFile(maryFile, "UTF-8")
val poemStream = source.getLines.toStream

poemStream
poemStream(4)
poemStream
