package ch14.lectures.sec05

object Matcher {

  def matcher(arr: Array[Int]) = {
    val x = arr match {
      case Array(0) => "0"
      case Array(x, y) => x + " " + y
      case Array(0, _*) => "0 ..."
      case _ => "Something else"
    }
    println(s"Array $x")
  }

  def matcher(lst: List[Int]) = {
    val x = lst match {
      case List(0) => "0"
      case List(x, y) => x + " " + y
      case List(0, _*) => "0 ..."
      case _ => "Something else"
    }
    println(s"List $x")
  }

  def matcher2(lst: List[Int]) = {
    val x = lst match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => x + " " + y
      case 0 :: tail => "0 ..."
      case _ => "Something else"
    }
    println(s"List $x")
  }

  def matcher(tup: (Int, Int)) = {
    val x = tup match {
      case (0, _) => "0..."
      case (y, 0) => y + " 0"
      case _ => "neither is 0"
    }
    println(s"Tup $x")
  }
}

import Matcher._

object Main extends App {
  matcher(Array(0))
  matcher(Array(0, 1))
  matcher(Array(0, 1, 2))
  matcher(Array(1))

  matcher(List(0))
  matcher(List(0, 1))
  matcher(List(0, 1, 2))
  matcher(List(1))

  matcher2(List(0))
  matcher2(List(0, 1))
  matcher2(List(0, 1, 2))
  matcher2(List(1))

  matcher((0, 1))
  matcher((7, 0))
  matcher((2, 2))
}