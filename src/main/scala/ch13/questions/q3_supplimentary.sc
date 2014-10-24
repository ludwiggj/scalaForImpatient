import scala.collection.mutable

val a = mutable.LinkedList[Int]()

//a.head              // NoSuchElementException
//a.tail              // java.lang.IllegalArgumentException: requirement failed: tail of empty list

a.next                // LinkedList() i.e. empty list
a.next.next           // LinkedList() i.e. empty list
a.next.next.next      // LinkedList() i.e. empty list

val b = mutable.LinkedList(1, 2)
b.head
b.tail
b.next
b.next == Nil
b.next.next
b.next.next == Nil

mutable.LinkedList() == Nil
mutable.LinkedList() == mutable.LinkedList.empty
mutable.LinkedList(1) == Nil
mutable.LinkedList(1) == mutable.LinkedList.empty