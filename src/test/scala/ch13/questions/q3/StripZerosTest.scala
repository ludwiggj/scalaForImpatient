package ch13.questions.q3

import org.scalatest.{FlatSpec, Matchers}
import scala.collection.mutable
import scala.language.postfixOps

class StripZerosTest extends FlatSpec with Matchers {

  "stripZeros" should "should strip leading zero" in {
    StripZeros.strip(mutable.LinkedList(0, 1, 2, 3, 4)) should equal(mutable.LinkedList(1, 2, 3, 4))
  }

  "stripZeros" should "should strip trailing zero" in {
    StripZeros.strip(mutable.LinkedList(1, 2, 3, 4, 0)) should equal(mutable.LinkedList(1, 2, 3, 4))
  }

  "stripZeros" should "return empty list if all entries are zero" in {
    StripZeros.strip(mutable.LinkedList(0, 0, 0, 0, 0)) should equal(mutable.LinkedList())
  }

  "stripZeros" should "return strip zeros from typical example" in {
    StripZeros.strip(mutable.LinkedList(0, 2, 6, 0, 4, 2, 0, 7)) should equal(mutable.LinkedList(2, 6, 4, 2, 7))
  }

  "stripZeros" should "return empty list if given empty list" in {
    StripZeros.strip(mutable.LinkedList()) should equal(mutable.LinkedList())
  }

  "stripZeros" should "return same list if no entries are zero" in {
    StripZeros.strip(mutable.LinkedList(1, 4, 6, 9, 2)) should equal(mutable.LinkedList(1, 4, 6, 9, 2))
  }
}