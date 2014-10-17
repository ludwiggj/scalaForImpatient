Set(2, 0, 1) + 1

val s = Set(1, 2, 3, 4, 5, 6)

for (x <- s) {
  print(s"$x ")
}


val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "Wed", "Th", "Fr")



for (x <- weekdays) {
  print(s"$x ")
}

val sortedWeekdays = scala.collection.immutable.SortedSet("Mo", "Tu", "Wed", "Th", "Fr")



for (x <- sortedWeekdays) {
  print(s"$x ")
}

val digits = Set(1, 7, 2, 9)
digits contains 0
Set(1, 2) subsetOf digits

val primes = Set(2, 3, 5, 7)

digits union primes
digits | primes
digits ++ primes

digits intersect primes
digits & primes

digits diff primes
digits &~ primes
digits -- primes

// Operators for adding / removing elements

// Adding one or more elements
Set(1) + 2
Set(1) + (3, 4, 5)

// Subtraction ignores elements that aren't present
Set(1, 2) - 0
Set(1, 2) - 1
Set(1, 2, 3) - (1, 2)
Set(1, 2) - (2, 3)

// Add two collections together
Set(1) ++ Set(3, 1, 5)
Set(1) ++: Set(3, 1, 5)

// Subtract a collection from another
Set(1, 3, 5) -- Set(1, 7, 5)
Set(1, 9) diff Set(3, 1, 5)

// Mutable operations
import scala.collection.mutable

val a = mutable.Set(1)
a += 2
a += (3, 4)
a ++= List(6, 8)

a -= 2
a -= (6, 8)
a --= List(9, 1)

// Adding to immutable
var numbers = Set(1, 2, 3)
numbers += 4
numbers