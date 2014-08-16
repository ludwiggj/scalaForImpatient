//Q5. How do you compute the average of an Array[Double]?
def average(a: Array[Double]) = {
  a.length match {
    case 0 => 0
    case n => a.sum / n
  }
}

average(Array())
average(Array(1, 2, 3))