// According to precedence rules, how are 3 + 4 -> 5 and 3 -> 4 + 5 evaluated?

// 3 + 4 -> 5
// Same precedence i.e.

(3 + 4) -> 5

// Interesting stuff going on with +
3.+(4).->(5)
(3.+(4)).->(5)
(3.+(4)).asInstanceOf[Int].->(5)

// both equal
3 + 4 -> 5

// and
// 3 -> 4 + 5

val x = 3 -> 4 // Is a tuple

// Not valid
3 -> 4 + 5

// Not valid
(3 -> 4) + 5

// This is OK

3 -> (4 + 5)