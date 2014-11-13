import scala.reflect.ClassTag

def makePair[T: Manifest](first: T, second: T) = {
  val r = new Array[T](2); r(0) = first; r(1) = second; r
}

makePair(4, 9)

def makeTriple[T: ClassTag](first: T, second: T, third: T) = {
  val r = new Array[T](3); r(0) = first; r(1) = second; r(2) = third; r
}

makeTriple("a", "b", "c")
makeTriple(10, 20, 30)