package ch21.lectures.pimped

import scala.language.implicitConversions

object Array2String extends App {
  implicit def array2string[T](x: Array[T]) = x.mkString("|")

  val x = Array(1, 2, 3)
  var v: String = x
  println(v)

  println(Array(1, 2, 3).mkString(" "))
}