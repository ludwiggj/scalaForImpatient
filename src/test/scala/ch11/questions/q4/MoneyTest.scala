package ch11.questions.q4

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

trait Amounts {
  val _369 = Money(3, 69)
  val _933 = Money(8, 133)
  val _minus505 = Money(-5, 5)
  val _302 = Money(3, 2)
  val _300 = Money(3, 0)
  val _minus300 = Money(-3, 0)
  val _002 = Money(0, 2)
  val _621 = Money(0, 621)
  val _minus005 = Money(0, -5)
  val _zero = Money(0, 0)
}

class MoneyTest extends FlatSpec with Matchers {

  "isNegative" should "return false for non-negative amounts" in {
    new Amounts {
      _369.isNegative should be(false)
      _933.isNegative should be(false)
      _302.isNegative should be(false)
      _300.isNegative should be(false)
      _002.isNegative should be(false)
      _621.isNegative should be(false)
      _zero.isNegative should be(false)
    }
  }

  "isNegative" should "return true for negative amounts" in {
    new Amounts {
      _minus005.isNegative should be(true)
      _minus300.isNegative should be(true)
      _minus505.isNegative should be(true)
    }
  }

  "isInvalid" should "should be true if both dollars and cents are negative" in {
    new Amounts {
      Money(-1, -1).isInvalid should be(true)
    }
  }

  "isInvalid" should "be true if dollars is positive but cents are negative" in {
    new Amounts {
      Money(1, -1).isInvalid should be(true)
    }
  }

  "isInvalid" should "be false for valid amounts" in {
    new Amounts {
      _zero.isInvalid should be(false)
      _minus505.isInvalid should be(false)
      _621.isInvalid should be(false)
    }
  }

  "asCents" should "be correct for zero and positive money amounts" in {
    new Amounts {
      _369.asCents should equal(369)
      _933.asCents should equal(933)
      _302.asCents should equal(302)
      _300.asCents should equal(300)
      _002.asCents should equal(2)
      _621.asCents should equal(621)
      _zero.asCents should equal(0)
    }
  }

  "asCents" should "be correct for negative money amounts" in {
    new Amounts {
      _minus005.asCents should equal(-5)
      _minus300.asCents should equal(-300)
      _minus505.asCents should equal(-505)
    }
  }

  "add" should "give correct result" in {
    new Amounts {
      (_369 + _621).asCents should equal(990)
      (_002 + _minus505).asCents should equal(-503)
      (_minus300 + _minus505).asCents should equal(-805)
      (_minus300 + _933 + _zero).asCents should equal(633)
    }
  }

  "minus" should "give correct result" in {
    new Amounts {
      (_369 - _621).asCents should equal(-252)
      (_621 - _369).asCents should equal(252)
      (_002 - _minus505).asCents should equal(507)
      (_minus300 - _minus505).asCents should equal(205)
      (_minus300 - _933 - _zero).asCents should equal(-1233)
      (_minus300 - _minus300).asCents should equal(0)
      (_621 - _621).asCents should equal(0)
      (_zero - _zero).asCents should equal(0)
    }
  }

  "==" should "give correct result" in {
    new Amounts {
      _369 == _369 should be(true)
      _621 == _369 should be(false)
      _300 == _minus300 should be(false)
    }
  }

  "<" should "give correct result" in {
    new Amounts {
      _369 < _369 should be(false)
      _621 < _369 should be(false)
      _369 < _621 should be(true)
      _300 < _minus300 should be(false)
      _minus300 < _300 should be(true)
    }
  }

  "toString" should "be correct for all amounts" in {
    new Amounts {
      _369.toString should equal("$3.69")
      _933.toString should equal("$9.33")
      _302.toString should equal("$3.02")
      _300.toString should equal("$3.00")
      _002.toString should equal("$0.02")
      _621.toString should equal("$6.21")
      _zero.toString should equal("$0.00")
      _minus005.toString should equal("$-0.05")
      _minus300.toString should equal("$-3.00")
      _minus505.toString should equal("$-5.05")
      (_369 + _621).toString should equal("$9.90")
      (_minus300 - _933 - _zero).toString should equal("$-12.33")
    }
  }

  "kahuna" should "be correct" in {
    Money(1, 75) + Money(0,50) == Money(2,25) should be(true)
    (Money(1, 75) + Money(0,50)).toString should equal("$2.25")
  }
}