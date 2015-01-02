import scala.runtime.RichInt

// Q5: Why does RichInt implement Comparable[Int] and not Comparable[RichInt] ?

// Presumably to avoid unnecessary implicit conversions from Int to RichInt

new RichInt(1).compareTo(2)
new RichInt(1).compareTo(new RichInt(3))