import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

implicit val isEven: Int => Boolean = _ % 2 == 0

implicit val isTupleSumEven: ((Int, Int)) => Boolean = {
  case (x, y) => (x + y) % 2 == 0
}
def workout[T](i: Iterable[T])(implicit predicate: T => Boolean) = {
  val res = mutable.StringBuilder.newBuilder

  def groupings[T](it: Iterator[Iterable[T]]): String = {
    (for (it1 <- it; it2 <- it1) yield it2).mkString("<Ta> ", " ", " <dah!>")
  }

  res ++= s"[$i]\n"
  res ++= s"  head [${i.head}]\n"
  res ++= s"  last [${i.last}]\n"
  res ++= s"  headOption [${i.headOption}]\n"
  res ++= s"  lastOption [${i.lastOption}]\n"
  res ++= s"  init [${i.init}]\n"
  res ++= s"  tail [${i.tail}]\n"
  res ++= s"  size [${i.size}]\n"
  res ++= s"  isEmpty [${i.isEmpty}]\n"
  res ++= s"  count [${i.count(predicate)}]\n"
  res ++= s"  forall [${i.forall(predicate)}]\n"
  res ++= s"  exists [${i.exists(predicate)}]\n"
  res ++= s"  filter [${i.filter(predicate)}]\n"
  res ++= s"  filterNot [${i.filterNot(predicate)}]\n"
  res ++= s"  partition [${i.partition(predicate)}]\n"
  res ++= s"  takeWhile [${i.takeWhile(predicate)}]\n"
  res ++= s"  dropWhile [${i.dropWhile(predicate)}]\n"
  res ++= s"  span [${i.span(predicate)}]\n"
  res ++= s"  take(2) [${i.take(2)}]\n"
  res ++= s"  drop(2) [${i.drop(2)}]\n"
  res ++= s"  splitAt(2) [${i.splitAt(2)}]\n"
  res ++= s"  takeRight(2) [${i.takeRight(2)}]\n"
  res ++= s"  dropRight(2) [${i.dropRight(2)}]\n"
  res ++= s"  slice(1, 4) [${i.slice(1, 4)}]\n"
  res ++= s"  grouped(2) [${groupings(i.grouped(2))}]\n"
  res ++= s"  sliding(2) [${groupings(i.sliding(2))}]\n"
  i.addString(res, "  addString [", " | ", "]\n")

  res
}
def workoutGeneric[T: ClassTag](i: Iterable[T]) = {
  val res = mutable.StringBuilder.newBuilder
  val a = new Array[T](i.size)
  i.copyToArray(a)
  res ++= s"  array copy [${a.mkString(", ")}]\n"

  val b = new Array[T](i.size)
  i.copyToArray(b, 4, 2)
  res ++= s"  array copy (2 elements, at position 4) [${b.mkString(", ")}]\n"

  val buf = new ArrayBuffer[T]()
  i.copyToBuffer(buf)
  res ++= s"  buffer copy [${buf.mkString(", ")}]\n"

  res
}






def workoutNumeric[T: Numeric](i: Iterable[T]) = {
  val res = mutable.StringBuilder.newBuilder
  res ++= s"  sum [${i.sum}]\n"
  res ++= s"  product [${i.product}]\n"
  res ++= s"  max [${i.max}]\n"
  res ++= s"  min [${i.min}]\n"

  // See http://stackoverflow.com/questions/2235332/scala-way-to-define-functions-accepting-a-list-of-different-numeric-types
  res ++= s"  reduceLeft(x - y) [${i.reduceLeft((l, r) => implicitly[Numeric[T]].minus(l, r))}]\n"
  res ++= s"  reduceRight(x - y) [${i.reduceRight((l, r) => implicitly[Numeric[T]].minus(l, r))}]\n"

  //TODO - fold left, fold right
  res
}

def workoutMap(m: Map[Int, Int]) = {
  val res = mutable.StringBuilder.newBuilder

  res ++= s"[$m]\n"

  res ++= s" foldLeft(0)(sum values) ${m.foldLeft(0)({
    case (a, (k, v)) => a + v
  })}\n"

  res ++= s" foldRight(0)(sum values) ${m.foldRight(0)({
    case ((k, v), a) => a + v
  })}\n"

  val start = ""

  // Type of result can be different from types in the map
  res ++= s" foldLeft(mtString)(add values) ${m.foldLeft(start)({
    case (a, (k, v)) => a + v
  })}\n"

  res ++= s" foldRight(mtString)(add values) ${m.foldRight(start)({
    case ((k, v), a) => a + v
  })}\n"

  // Tuple tricks!
  def addTuples(t1: (Int, Int), t2: (Int, Int)) = (t1._1 + t2._1, t1._2 + t2._2)

  res ++= s" reduceLeft((x1 + y1, x2 + y2)) ${m.reduceLeft((l, r) => addTuples(l, r))}\n"
  res ++= s" reduceRight((x1 + y1, x2 + y2)) ${m.reduceRight((l, r) => addTuples(l, r))}\n"

  val interimRes = mutable.StringBuilder.newBuilder

  res ++= s" reduceLeft((x1 + x2, y1 + y2)) ${
    (m.reduceLeft _) {
      case ((x1, x2), (y1, y2)) => {
        interimRes ++= s"  (x1: $x1, x2: $x2) (y1: $y1, y2: $y2) = ${(x1 + x2, y1 + y2)}\n"
        (x1 + x2, y1 + y2)
      }
    }
  }\n"

  res ++= interimRes

  interimRes.clear

  res ++= s" reduceRight((x1 + x2, y1 + y2)) ${
    (m.reduceRight _) {
      case ((x1, x2), (y1, y2)) => {
        interimRes ++= s"  (x1: $x1, x2: $x2) (y1: $y1, y2: $y2) = ${(x1 + x2, y1 + y2)}\n"
        (x1 + x2, y1 + y2)
      }
    }
  }\n"
  res ++= interimRes
  res
}
val list = List(1, 2, 3, 4, 5, 6)
println(workout(list) ++= workoutNumeric(list) ++= workoutGeneric(list))









































































































val set = Set(1, 2, 3, 4, 5, 6)
println(workout(set) ++= workoutNumeric(set) ++= workoutGeneric(set))




































































































val map = Map(1 -> 1, 2 -> 2, 3 -> 3, 6 -> 4, 5 -> 8, 12 -> 1)


println(workout(map) ++= workoutGeneric(map) ++= workoutMap(map))


















































































