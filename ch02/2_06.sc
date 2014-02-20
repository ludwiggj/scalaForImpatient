for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")

for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")

for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")

for { i <- 1 to 3
     from = 4 - i
     j <- from to 3 }
  print((10 * i + j) + " ")

for (i <- 1 to 10) yield i % 3

// Yields from Scala for Impatient
for (c <- "Hello") yield c
// Returns a string
for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
// Returns a vector
for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar

// Map is the first operation within for
"Hello" map (x => x + 1)

0 to 1 map (x => x + 1)

// More for examples follow.....
val range = 1 to 5
// no return value if there is no 'yield' keyword
for(i <- 1 to 10) {i + 1}

// if there is a yield a collection is returned
// the type of collection depends on the input
// here a Range is returned
// NO - actually returns IndexedSeq[Int] i.e. Vector of Ints
for (i <- range) yield i + 1

// here a list is returned i.e. List[String]
for (i <- List("a", "b", "c")) yield "Word: " + i

// you can filter the elements that visited in the loop
// returns IndexedSeq[Int] i.e. Vector of Ints
for (i <- range; if (i % 2 == 0)) yield i

// this is more about creating ranges than loops
for (i <- 20 until (10,-2)) yield i

// you can string together multiple "generators"
// returns IndexedSeq[(Int, Int)] i.e. Vector of tuples
for (i <- range; j <- range) yield (i,j)



