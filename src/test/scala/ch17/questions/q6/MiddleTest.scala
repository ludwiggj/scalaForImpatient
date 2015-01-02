package ch17.questions.q6

import org.scalatest.{FlatSpec, Matchers}

class MiddleTest extends FlatSpec with Matchers {

  "Middle of World" should "be r" in {
    middle("World") should equal(Some('r'))
  }

  "Middle of List(2, 6, 10, 2, 5)" should "be 10" in {
    middle(List(2, 6, 10, 2, 5)) should equal(Some(10))
  }

  "Middle of Set('a')" should "be a" in {
    middle(Set('a')) should equal(Some('a'))
  }

  "Middle of empty list" should "be None" in {
    middle(List[Int]()) should equal(None)
  }
}