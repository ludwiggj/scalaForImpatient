val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

scores("Bob") = 10
scores("Fred") = 7

scores

val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

scores += ("Bob" -> 10, "Fred" -> 7) // allowed
scores -= "Alice"       // allowed
scores = scores - "Bob" // not allowed (val)

val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

val newScores = scores + ("Bob" -> 10, "Fred" -> 7) // New map with update

scores = newScores // Not allowed (val)

scores = scores - "Bob" // Not allowed (immutable map)

scores -= "Bob" // Not allowed (immutable map)

var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

scores = scores + ("Bob" -> 10, "Fred" -> 7)

scores = scores - "Alice"

scores -= "Bob"

scores