package ch12.lectures.sec10

import ch12.lectures.sec09.Main2._

object returnExample extends App {
  // Must specify return type of indexOf
  // as it uses the return expression
  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    -1
  }

  println(indexOf("Hello", 'o'))
  println(indexOf("Hello", 'z'))
}