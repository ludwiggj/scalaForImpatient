val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

for ((k, v) <- scores) println(k + " is mapped to " + v)

scores.keySet

for (v <- scores.values) println(v)

for ((k, v) <- scores) yield (v, k)