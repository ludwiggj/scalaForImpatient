//1. Set up a map of prices for a number of gizmos that you covet. Then produce
//   a second map with the same keys and the prices at a 10 percent discount.

val gizmos = Map("Laser gun" -> 200.0, "Teleporter" -> 3000.0, "Death ray" -> 15500.0)

// Solution 1
gizmos map ({
  case (k, v) => (k, 0.9 * v)
})

// Solution 2
for ((k, v) <- gizmos) yield (k, 0.9 * v)
