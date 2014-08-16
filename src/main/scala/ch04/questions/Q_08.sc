//Q8. Write a function minmax(values: Array[Int]) that returns a pair containing the
//smallest and largest values in the array.

import scala.language.postfixOps
def minmax(values: Array[Int]) = {
  (values min, values max)
}

minmax(Array(-1, -2, -4, 0, 2, 4, 6))
minmax(Array(-1, -2, -24, 10, 2, 24, 6))
minmax(Array(-11, -2, -41, 20, 2, 4, 16))