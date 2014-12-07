class Pair[+T](val first: T, val second: T)

val p = new Pair(1, 2)

// Not allowed, as first is a val
// p.first = 3

// Not allowed...
// Error:(6, 8) covariant type T occurs in contravariant position in type T of value first_=
// Error:(6, 8) covariant type T occurs in contravariant position in type T of value second_=

// class Pair2[+T](var first: T, var second: T)

// trait IndexedSeqOptimized[+A, +Repr] extends scala.Any with scala.collection.IndexedSeqLike[A, Repr] {
// override def foldLeft[B](z : B)(op : scala.Function2[B, A, B]) : B = { /* compiled code */ }

// trait IndexedSeqOptimized[+A, +Repr] extends scala.Any with scala.collection.IndexedSeqLike[A, Repr] {
// override def foldLeft[B](z : B)(op : scala.Function2[B, A, B]) : B = { /* compiled code */ }