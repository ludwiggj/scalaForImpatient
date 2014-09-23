package ch12.questions.q6

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class LargestTest extends FlatSpec with Matchers {

  "largestInput1" should "should return input value for which function returns the largest value, given a sequence of inputs" in {
     largestInput1(x => 10 * x - x * x, 1 to 10) should equal(5)
  }

  "largestInput2" should "should return input value for which function returns the largest value, given a sequence of inputs" in {
     largestInput2(x => 10 * x - x * x, 1 to 10) should equal(5)
  }

  "largestInput3" should "should return input value for which function returns the largest value, given a sequence of inputs" in {
     largestInput3(x => 10 * x - x * x, 1 to 10) should equal(5)
  }
}