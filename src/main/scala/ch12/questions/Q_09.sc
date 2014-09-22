import scala.collection.GenSeq

// Implement corresponds without currying, then try the
// call form the preceding exercise. What problem do
// you encounter?

// Use "pimp my library" pattern (taken from Internet, don't understand it yet!)
class FooArray[A](at: Array[A]) {
  def foo() = at.length * at.length

  def corresponds[B](that: GenSeq[B])(p: (A, B) => Boolean): Boolean = {
    val i = at.iterator
    val j = that.iterator
    while (i.hasNext && j.hasNext)
      if (!p(i.next, j.next))
        return false

    !i.hasNext && !j.hasNext
  }

  def correspondsUncurried[B](that: GenSeq[B], p: (A, B) => Boolean): Boolean = {
    corresponds(that)(p)
  }
}

implicit def array2foo[A](at: Array[A]) = new FooArray(at)


Array(1, 2, 3).foo

val a = Array("hello", "world")
val b = Array("hello", "world")
a.corresponds(b)((p, q) => p.equalsIgnoreCase(q))
// Need to specify types of p & q for uncurried version
a.correspondsUncurried(b, (p: String, q: String) => p.equalsIgnoreCase(q))
val c = Array("Hello", "my", "dear", "old", "thing")
val d = Array(5, 2, 4, 3, 5)

c.corresponds(d)(_.size == _)

// Need to specify types of p & q for uncurried version
c.correspondsUncurried(d, (p: String, q: Int) => p.size == q)


// Same deal if just define method, passing both arrays in...
def corresponds[A, B](first: Seq[A], second: Seq[B], f: (A, B) => Boolean) = {
  (first.zip(second)).map(x => f(x._1, x._2)).count(!_) == 0
}
corresponds(a, b, (p: String, q: String) => p.equalsIgnoreCase(q))