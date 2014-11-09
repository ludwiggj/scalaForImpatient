import scala.reflect.ClassTag

def swap(x: Array[Int]) = {
  x match {
    case Array(first, second, rest @ _*) => Array(second, first) ++ rest
    case _ => x
  }
}
swap(Array[Int](2,3,4,5,6,7))

def swapAgain[T: ClassTag](x: Array[T]) = {
  x match {
    case Array(first, second, rest @ _*) => Array(second, first) ++ rest
    case _ => x
  }
}

swapAgain(Array(2,3,4,5,6,7))
swapAgain(Array(2.0,3,4,5,6,7))
swapAgain(Array("2","3","4","5","6","7", "8"))
swapAgain(Array(0))
swapAgain(Array(0, 1))