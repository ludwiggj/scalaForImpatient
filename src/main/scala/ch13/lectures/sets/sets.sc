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

Set(1) + 2
Set(1) + (3, 4, 5)