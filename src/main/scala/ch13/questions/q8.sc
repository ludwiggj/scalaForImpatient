def to2DArray(x: Array[Int], cols: Int): Array[Array[Int]] = {
  (x grouped cols).toArray
}

def display(x: Array[Array[Int]]) =
  (x map (_.mkString(" "))).mkString("|")

display(to2DArray(Array(1, 2, 3, 4, 5, 6), 1))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 2))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 3))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 4))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 5))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 6))
display(to2DArray(Array(1, 2, 3, 4, 5, 6), 7))