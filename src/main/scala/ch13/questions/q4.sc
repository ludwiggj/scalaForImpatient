val a = Array("Tom", "Fred", "Harry")
a.mkString(" ")
val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

val b = a map {m.get(_)}
val c = a flatMap {m.get(_)}
b.mkString(" ")
c.mkString(" ")