val a = 9 :: List(4, 2)
8 :: Nil
9 :: (4 :: (2 :: Nil))
// :: right associative
// Thus following is invalid
// :: is not a member of int
// (((9 :: 4) :: 2) :: Nil)

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

setEveryNegativeElementToZero(LinkedList(1, -2, 7, -9))
removeEverySecondElementFromList(LinkedList(1, -2, 7, -9))
makeListNoMoreThanTwoElementsLong(LinkedList())
makeListNoMoreThanTwoElementsLong(LinkedList(1))
makeListNoMoreThanTwoElementsLong(LinkedList(1, 2))
makeListNoMoreThanTwoElementsLong(LinkedList(4, 3, 2, 1))