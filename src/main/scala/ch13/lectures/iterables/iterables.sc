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

  res ++= "workout\n"
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

  res ++= "workoutGeneric\n"
  res ++= s"[$i]\n"

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

def workoutZip[T](i: Iterable[T], j: Iterable[T]) = {
  val res = mutable.StringBuilder.newBuilder

  res ++= "workoutZip\n"
  res ++= s"i=[$i]\nj=[$j]\n"
  res ++= s"  i zip j ${i zip j}\n"

  res
}

def workoutNumericZip[T: Numeric, S: Numeric](i: Iterable[T], j: Iterable[S]) = {
  val res = mutable.StringBuilder.newBuilder

  res ++= "workoutZip\n"
  res ++= s"i=[$i]\nj=[$j]\n"
  res ++= s"  i zip j ${i zip j}\n"

  def multiplyUp: ((T, S)) => Double = {
    pp => implicitly[Numeric[T]].toDouble(pp._1) *
      implicitly[Numeric[S]].toDouble(pp._2)
  }

  val costs = (i zip j) map multiplyUp
  val indexedCosts = costs.zipWithIndex

  res ++= s"      Costs (zip) $costs\n"
  res ++= s"   Max cost (zip) ${indexedCosts.max}\n"
  res ++= s"Max cost idx(zip) ${indexedCosts.max._2}\n"
  res ++= s" Total cost (zip) ${costs.sum}\n"

  val zipAll =
    i zipAll(j, implicitly[Numeric[T]].one, implicitly[Numeric[S]].one)

  res ++= s"  i zipAll j $zipAll\n"

  val costsWithDefaults = zipAll map multiplyUp

  res ++= s"     Costs (zipAll) $costsWithDefaults\n"
  res ++= s"Total cost (zipAll) ${costsWithDefaults.sum}\n"
  res
}

def workoutNumeric[T: Numeric](i: Iterable[T]) = {
  val res = mutable.StringBuilder.newBuilder

  res ++= "workoutNumeric\n"
  res ++= s"[$i]\n"
  res ++= s"  sum [${i.sum}]\n"
  res ++= s"  product [${i.product}]\n"
  res ++= s"  max [${i.max}]\n"
  res ++= s"  min [${i.min}]\n"
  // See http://stackoverflow.com/questions/2235332/scala-way-to-define-functions-accepting-a-list-of-different-numeric-types
  res ++= s"  reduceLeft(x - y) [${i.reduceLeft((l, r) => implicitly[Numeric[T]].minus(l, r))}]\n"
  res ++= s"  reduceRight(x - y) [${i.reduceRight((l, r) => implicitly[Numeric[T]].minus(l, r))}]\n"
  res
}
val list = List[Int](1, 2, 3, 4, 5, 6)
println(workout(list))
println(workoutNumeric(list))
println(workoutGeneric(list))
val prices: List[Double] = List(2.5, 1.2, 0.9, 5.1, 2.6, 19.1)
val listQuantities = list
println(workoutNumericZip(prices, listQuantities))
println(workoutNumericZip(prices, listQuantities drop 3))
val set = Set(1, 2, 3, 4, 5, 6)
val setQuantities = set
println(workout(set))
println(workoutNumeric(set))
println(workoutGeneric(set))
println(workoutNumericZip(prices, setQuantities))
println(workoutNumericZip(prices, setQuantities dropRight 4))
val map = Map(1 -> 1, 2 -> 2, 3 -> 3, 6 -> 4, 5 -> 8, 12 -> 1)
println(workout(map))
println(workoutGeneric(map))
println(workoutZip(map, map))