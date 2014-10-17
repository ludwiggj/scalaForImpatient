val a = 9 :: List(4, 2)
8 :: Nil
9 :: (4 :: (2 :: Nil))
// :: right associative
// Thus following is invalid
// :: is not a member of int
// (((9 :: 4) :: 2) :: Nil)
def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)

def sum2(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum(t)
}

sum(a)
sum2(a)
a.sum

// Mutable list
import scala.collection.mutable.LinkedList

def setEveryNegativeElementToZero(lst: LinkedList[Int]): LinkedList[Int] = {
  var cur = lst
  while (cur != Nil) {
    if (cur.elem < 0) cur.elem = 0
    cur = cur.next
  }
  lst
}


def removeEverySecondElementFromList(lst: LinkedList[Int]): LinkedList[Int] = {
  var cur = lst
  while (cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }
  lst
}

def makeListNoMoreThanTwoElementsLong(lst: LinkedList[Int]): LinkedList[Int] = {
  val cur = lst
  if (cur != Nil && cur.next != Nil && cur.next.next != Nil) {
    cur.next.next = LinkedList.empty
  }
  lst
}

println(setEveryNegativeElementToZero(LinkedList(1, -2, 7, -9)))
println(removeEverySecondElementFromList(LinkedList(1, -2, 7, -9)))
println(makeListNoMoreThanTwoElementsLong(LinkedList()))
println(makeListNoMoreThanTwoElementsLong(LinkedList(1)))
println(makeListNoMoreThanTwoElementsLong(LinkedList(1, 2)))
println(makeListNoMoreThanTwoElementsLong(LinkedList(4, 3, 2, 1)))