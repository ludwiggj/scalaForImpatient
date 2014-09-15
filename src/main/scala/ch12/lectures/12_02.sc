// Anonymous functions

(x: Double) => 3 * x

val triple = (x: Double) => 3 * x
def triple2(x: Double) = 3 * x

Array(3.14, 1.42, 2.0) map triple
Array(3.14, 1.42, 2.0) map triple2
Array(3.14, 1.42, 2.0) map ((x: Double) => 3 * x)
Array(3.14, 1.42, 2.0) map {(x: Double) => 3 * x}