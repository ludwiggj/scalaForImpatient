import scala.collection.mutable

def workoutMap(m: Map[Int, Int]) = {
  val res = mutable.StringBuilder.newBuilder

  res ++= s"[$m]\n"

  res ++= s" foldLeft(0)(sum values) ${
    m.foldLeft(0)({
      case (a, (k, v)) => a + v
    })
  }\n"

  res ++= s" scanLeft(0)(sum values) ${
      m.scanLeft(0)({
        case (a, (k, v)) => a + v
      })
  }\n"

  res ++= s" foldRight(0)(sum values) ${
    m.foldRight(0)({
      case ((k, v), a) => a + v
    })
  }\n"

  val start = ""

  // Type of result can be different from types in the map
  res ++= s" foldLeft(mtString)(add values) ${
    m.foldLeft(start)({
      case (a, (k, v)) => a + v
    })
  }\n"

  res ++= s" foldRight(mtString)(add values) ${
    m.foldRight(start)({
      case ((k, v), a) => a + v
    })
  }\n"

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

val map = Map(1 -> 1, 2 -> 2, 3 -> 3, 6 -> 4, 5 -> 8, 12 -> 1)

println(workoutMap(map))