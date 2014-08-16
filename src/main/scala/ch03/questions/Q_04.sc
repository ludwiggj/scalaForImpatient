//Q4 Given an array of integers, produce a new array that contains all positive
//values of the original array, in their original order, followed by all values that
//are zero or negative, in their original order.

def sortArray(a: Array[Int]) = {
  ((for (i <- 0 until a.length if a(i) > 0) yield a(i))
    ++ (for (i <- 0 until a.length if a(i) <= 0) yield a(i))).toArray
}
def sortArrayWithFilter(a: Array[Int]) = {
  (a filter (_ > 0)) ++ (a filter (_ <= 0))
}

sortArray(Array(2, 5, -4, 2, -9, -8, 0, 3))
sortArrayWithFilter(Array(2, 5, -4, 2, -9, -8, 0, 3))