/*
It may seem strange to restrict method parameters in an immutable class Pair[+T] however suppose you could define

def replaceFirst(newFirst:T)

in a Pair[+T]. The problem is that this method can be overridden in an unsound way.
Construct an example of this problem. Define a subclass NastyDoublePair of Pair[Double] that overrides
replaceFirst so that it makes a pair with the square root of newFirst. Then construct the call
replaceFirst("Hello") on a Pair[Any] that is actually a NastyDoublePair
*/

class Pair[+T](val first: T, val second: T) {

  // Error: covariant type T occurs in contravariant position in type T of value newFirst
  // def replaceFirst(newFirst: T) = new Pair(newFirst, second)
  def replaceSecond[T >: String](newSecond: T) = new Pair(first, newSecond)
}

class NastyDoublePair(first: Double, second: Double) extends Pair(first, second) {
  // override def replaceFirst(newFirst: Double) = new Pair(math.sqrt(newFirst), second)

  // Compile spots in this case the replaceSecond cannot override replaceSecond in Pair,
  // due to additional type information (lower bound)

  // override def replaceSecond(newSecond: Double) = new Pair(math.sqrt(first), newSecond)
}

// If the above were allowed by the compiler, we could do the following...

val x: Pair[Any] = new NastyDoublePair(1.0, 2.0)
// x.replaceFirst("Hello")

// The overridden replaceFirst in NastyDoublePair would be called, and square root
// called on a string!