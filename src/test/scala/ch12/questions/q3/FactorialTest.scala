package ch12.questions.q3

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class FactorialTest extends FlatSpec with Matchers {

  "0!" should "return 1" in {
    factorial(0) should equal(1)
  }

  "1!" should "return 1" in {
    factorial(1) should equal(1)
  }

  "2!" should "return 2" in {
    factorial(2) should equal(2)
  }

  "3!" should "return 6" in {
    factorial(3) should equal(6)
  }

  "9!" should "return 362880" in {
    factorial(9) should equal(362880)
  }
}