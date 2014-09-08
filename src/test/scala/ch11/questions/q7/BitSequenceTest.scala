package ch11.questions.q7

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class BitSequenceTest extends FlatSpec with Matchers {

  "Default BitSequence" should "return 0 for all positions" in {
    val b = new BitSequence
    (0 to 63) foreach (b(_) should equal(0))
  }

  "Set BitSequence bit" should "enable setting of individual bit to 0 or 1" in {
    val b = new BitSequence
    (0 to 63) foreach { b(_) = 1 }
    (25 to 36) foreach { i => if (i % 2 == 0) b(i) = 0}

    b(0) should equal(1)
    b(25) should equal(1)
    b(34) should equal(0)
    b(63) should equal(1)
  }
}