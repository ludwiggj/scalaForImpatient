/*
Given a mutable Pair[S, T] class, use a type constraint to define a swap method
that can be called if the type parameters are the same
*/

class Pair[S, T](var first: S, var second: T) {
  def swap(implicit ev: S =:= T) = {
    val temp = first.asInstanceOf[T]
    first = second.asInstanceOf[S]
    second = temp
    this
  }

  override def toString = s"($first, $second)"
}

val x = new Pair(1, 5)
x.swap

val y = new Pair(1, 1.5)

// Following does not work...

// Error: Cannot prove that Int =:= Double.
y.swap