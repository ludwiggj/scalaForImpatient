//2. Write a loop that swaps adjacent elements of an array of integers. For example,
//Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
def neighbourSwapOld(x: Array[Any]) = {
  for (i <- 0 until x.length/2) {
    val startIndex = 2*i
    var tmp = x(startIndex)
    x(startIndex) = x(startIndex+1)
    x(startIndex+1) = tmp
  }
  x
}
def neighbourSwap(x: Array[Any]) = {
  for (i <- 0 until (x.length - 1) by 2) {
    var tmp = x(i)
    x(i) = x(i+1)
    x(i+1) = tmp
  }
  x
}
neighbourSwap(Array())
neighbourSwap(Array(1))
neighbourSwap(Array(1,2))
neighbourSwap(Array(1,2,3))
neighbourSwap(Array(1,2,3,4))
neighbourSwap(Array(1,2,3,4,5))
neighbourSwap(Array(1,2,3,4,5,6))
neighbourSwap(Array(1,2,3,4,5,6,7))
neighbourSwap(Array(1,2,3,4,5,6,7,8))
neighbourSwap(Array(1,2,3,4,5,6,7,8,9))
neighbourSwap(Array(1,2,3,4,5,6,7,8,9,10))