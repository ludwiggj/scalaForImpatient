class Pair[T, S](val first: T, val second: S)

val p = new Pair(42, "String")
val p2 = new Pair[Any, Any](42, "String")
