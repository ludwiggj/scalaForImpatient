// 6. How do you rearrange the elements of an Array[Int] so that they appear in
//    reverse sorted order? How do you do the same with an ArrayBuffer[Int]?

def reverseSorted(a: Array[Int]) = {
  a.sorted.reverse
}

reverseSorted(Array(1,5,8,2,4,7,6,3))

import scala.collection.mutable.ArrayBuffer

def reverseSorted(a: ArrayBuffer[Int]) = {
  a.sorted.reverse
}

reverseSorted(ArrayBuffer(1,5,8,2,4,7,6,3))