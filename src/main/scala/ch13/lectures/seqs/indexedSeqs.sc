import scala.collection.mutable.ArrayBuffer

val a = ArrayBuffer(1, 2, 3)

// Operators for adding / removing elements

// Adding an element
a :+ 4
5 +: a

Vector(1, 2, 3) :+ 5
1 +: Vector(1, 2, 3)

// Adding to immutable
var numbers = Vector(1, 2, 3)
numbers :+= 4
numbers

// Subtracting one or more elements
a - 0
a - 1
a - (2, 4)
// Add two collections together
a ++ ArrayBuffer(4, 6, 8)
a ++: ArrayBuffer(41, 61, 82)

// Subtract a collection from another
a -- ArrayBuffer(2, 9)
a diff ArrayBuffer(2, 9)

// Prepend element
12 +=: ArrayBuffer(4, 6, 8)
ArrayBuffer(32, 1) ++=: ArrayBuffer(41, 61, 82)
