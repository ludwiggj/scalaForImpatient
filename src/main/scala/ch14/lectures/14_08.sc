import scala.collection.JavaConversions.propertiesAsScalaMap

for ((k, v) <- System.getProperties())
  println(k + " -> " + v)

val m = Map("1" -> "One", "x" -> "", "2" -> "Two")

for ((k, "") <- m)
  println(k)

for ((k, v) <- m if v == "")
  println(k)