package ch13.questions.q5

import org.scalatest.{FlatSpec, Matchers}

import scala.language.postfixOps

class MkStringTest extends FlatSpec with Matchers {

  "MkString" should "work as mkString on list of strings" in {
    val list = List("This", "is", "a", "test")
    MkString.make(list, " ") should equal(list.mkString(" "))
  }

  "MkString" should "work as mkString on list of ints" in {
    val list = List(1, 2, 3, 4)
    MkString.make(list, " ") should equal(list.mkString(" "))
  }

  "MkString" should "work as mkString on empty collection" in {
    val set = Set[Double]()
    MkString.make(set, " ") should equal(set.mkString(" "))
  }
}