import scala.collection.mutable

def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)

def workout(i: Iterable[String]) = {
  val res = mutable.StringBuilder.newBuilder
  res ++= s"[$i]\n"
  res ++= s"  map(_.toUpperCase) [${i.map(_.toUpperCase)}]\n"
  res ++= s"  for equivalent [${for (v <- i) yield v.toUpperCase}]\n"
  res ++= s"  map(ulCase(_)) [${i.map(ulcase(_))}]\n"
  res ++= s"  flatmap(ulCase(_)) [${i.flatMap(ulcase(_))}]\n"
  res ++= s"  for map equivalent [${for (v <- i) yield ulcase(v)}]\n"
  res ++= s"  for flatMap equivalent [${for { v <- i; u <- ulcase(v) } yield u}]\n"

  res
}

def mapWorkout(m: Map[String, Int]) = {
  val res = mutable.StringBuilder.newBuilder
  res ++= s"[$m]\n"
  res ++= s"  map(keys.toUpperCase) [${m.map({case (k, v) => k.toUpperCase -> v})}]\n"
  res ++= s"  for equivalent [${for ((k, v) <- m) yield (k.toUpperCase -> v)}]\n"
  res
}

val list = List("Peter", "Paul", "Mary")
println(workout(list))
val set = Set("Peter", "Paul", "Mary")
println(workout(set))
val map = Map("Peter" -> 1, "Paul" -> 2, "Mary" -> 3)
println(mapWorkout(map))
println("collect:" + "-3+4".collect { case '+' => 6; case '-' => 9 })

val freq = scala.collection.mutable.Map[Char, Int]()
for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
println(s"Frequency of letter in Mississippi (for): $freq")

println(s"Frequency of letter in Mississippi (foldLeft): ${
  (Map[Char, Int]() /: "Mississippi") {
    (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
  }
}")