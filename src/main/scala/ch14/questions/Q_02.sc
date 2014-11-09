def swap(x: (Int, Int)) = {
  x match {
    case (x1, x2) => (x2, x1)
  }
}

swap((2,3))
swap((6,2))