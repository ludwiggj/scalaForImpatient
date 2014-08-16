import scala.language.postfixOps

//Q9 Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
//the counts of values less than v, equal to v, and greater than v.

def lteqgt(values: Array[Int], v: Int) = {
  (values filter {_ < v} length,
   values filter {_ == v} length,
   values filter {_ > v} length)
}

lteqgt(Array(-1, -2, -4, 0, 2, 4, 6), -3)
lteqgt(Array(-1, -2, -4, 0, 2, 4, 6), 1)
lteqgt(Array(-1, -2, -4, 0, 2, 4, 6), 4)