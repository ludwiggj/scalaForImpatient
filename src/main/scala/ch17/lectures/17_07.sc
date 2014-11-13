import Ordering.Implicits.infixOrderingOps

// More than one context bound
def makeDescendingPair[T: Manifest: Ordering](first: T, second: T) = {
  val smaller = if (first < second) first else second
  val larger = if (first >= second) first else second
  val r = new Array[T](2); r(0) = larger; r(1) = smaller; r
}

makeDescendingPair(4, 9)
makeDescendingPair(4, 4)
makeDescendingPair(4, 5)
makeDescendingPair(14, 5)

// More than one view bound
class Pair[T <% Comparable[T] <% String](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
  def larger = if (first.compareTo(second) >= 0) first else second
  override def toString = s"$smaller [${smaller.length}] $larger [${larger.length}]"
}

// Error No implicit view available from Int => String.
// val p = new Pair(42, 15)

val q = new Pair("Zebra", "Alligator")
val r = new Pair("Aardvark", "Alligator")