package ch12.questions.q6

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class LargestTest extends FlatSpec with Matchers {

  "largest" should "should return input value for which function returns the largest value, given a sequence of inputs" in {
     largestInput(x => 10 * x - x * x, 1 to 10) should equal(5)
   }
}