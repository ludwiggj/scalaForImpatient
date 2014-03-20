//3. Repeat the preceding assignment, but produce a new array with the swapped
//values. Use for/yield.

def neighbourSwap(a: Array[Any]) = {
  for (i <- 0 until a.length by 2; j <- (i + 1) to i by -1 if (j < a.length)) yield a(j)
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