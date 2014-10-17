// Operators for adding / removing elements

// Adding one or more elements
Map(1 -> 1) + (2 -> 2)
Map(2 -> 2) + (3 -> 3, 4 -> 4, 5 -> 5)


// Adding same key updates value
Map(2 -> 2) + (2 -> 3, 4 -> 4)

// Subtraction based on keys only
// Subtraction ignores elements that aren't present
Map(2 -> 2) - 2
Map(1 -> 1, 2 -> 2) - 0
Map(1 -> 1, 2 -> 2, 3 -> 3) - (1, 2)
Map(1 -> 1, 2 -> 2) - (2, 3)

// Add two collections together
Map(1 -> 1) ++ Map(2 -> 2)
Map(1 -> 1) ++: Map(2 -> 2)

// Subtract a collection from another
Map(1 -> 1) -- Set(1)
Map(1 -> 1, 2 -> 2) -- List(2, 4)

// Mutable operations
import scala.collection.mutable

val a = mutable.Map(1 -> 1)
a += 2 -> 2
a += (3 -> 3, 4 -> 4)
a ++= Map(6 -> 6, 8 -> 8)

a -= 2
a -= (6, 8)
a --= List(9, 1)