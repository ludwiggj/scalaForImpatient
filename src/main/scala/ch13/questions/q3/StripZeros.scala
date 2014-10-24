package ch13.questions.q3

import scala.collection.mutable

object StripZeros {

  def strip(l: mutable.LinkedList[Int]): mutable.LinkedList[Int] = {
    var prev: mutable.LinkedList[Int] = mutable.LinkedList.empty

    var result = l
    var current = l

    def atFirstElement = result == current

    while (current != Nil) {
      if (current.elem == 0) {
        // remove element
        if (atFirstElement) {
          result = current.next
        } else {
          prev.next = current.next
        }
      }
      // Move to next element
      prev = current
      current = current.next
    }
    result
  }

  def stripOriginal(l: mutable.LinkedList[Int]): mutable.LinkedList[Int] = {
    var prev: mutable.LinkedList[Int] = mutable.LinkedList[Int]()
    var atFirstElem = true

    var result = l
    var current = l

    while (current != Nil) {
      if (current.elem == 0) {
        // remove element
        if (atFirstElem) {
          result = result.next
        } else {
          prev.next = current.next
        }
      } else {
        // No longer at first element
        atFirstElem = false;
      }
      // Move to next element
      prev = current
      current = current.next
    }
    result
  }
}