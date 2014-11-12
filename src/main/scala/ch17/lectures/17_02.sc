def getMiddle[T](a: Array[T]) = a(a.length / 2)

getMiddle(Array("Mary", "had", "a", "little", "lamb"))

val f = getMiddle[Int] _

f(Array(1,2,3,4,5,6,7))