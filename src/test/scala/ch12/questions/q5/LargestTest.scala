package ch12.questions.q5

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class LargestTest extends FlatSpec with Matchers {

  "largest" should "should return largest value for a function, given a sequence of inputs" in {
    largest(x => 10 * x - x * x, 1 to 10) should equal(25)
  }
}