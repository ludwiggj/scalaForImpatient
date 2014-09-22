// Make a call to corresponds that checks whether the
// elements in an array of strings have the lengths
// given in an array of integers

val a = Array("Hello", "World")
val b = Array("hello", "world")

a.corresponds(b)(_.equalsIgnoreCase(_))

val c = Array("Hello", "my", "dear", "old", "thing")
val d = Array(5, 2, 4, 3, 5)
val e = Array(5, 2, 4, 31, 5)
c.corresponds(d)(_.size == _)
c.corresponds(e)(_.size == _)