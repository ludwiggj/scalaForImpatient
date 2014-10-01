package ch21.lectures.pimped

import scala.language.implicitConversions
import scala.reflect.ClassTag

class RichArray[T](value: Array[T]) {
  def append[T:ClassTag](other: Array[T]): Array[T] = {
    val result = new Array[T](value.length + other.length)
    Array.copy(value, 0, result, 0, value.length)
    Array.copy(other, 0, result, value.length, other.length)
    result
  }

  def show = value.mkString("#")
}

object Main extends App {
  implicit def enrichArray[T](xs: Array[T]) = new RichArray[T](xs)
  implicit def array2string[T](x: Array[T]) = x.mkString("|")

  val x = Array(1, 2, 3)
  val y = Array(4, 5, 6)
  val z = x append y
  val zAsString: String = z

  println(z)
  println(zAsString)
  println(z.show)
}