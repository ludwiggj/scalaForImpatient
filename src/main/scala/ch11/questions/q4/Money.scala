package ch11.questions.q4

import scala.language.postfixOps

object Money {
  def apply(c: Int): Money = new Money(c)
  def apply(d: Int, c: Int): Money = new Money(d, c)
}

class Money(d: Int, c: Int) {

  def this(c: Int) {
    this(0, c)
  }

  private val conversionFactor = 100
  val isInvalid = (d != 0) && (c < 0)
  val isNegative = (d < 0) || ((d == 0) && (c < 0))
  val asCents = {
    val absCents = math.abs(d) * conversionFactor + math.abs(c)
    if (isNegative) -absCents else absCents
  }

  private val asDollarsAndCents = {
    val dollars = asCents / conversionFactor
    val cents = math.abs(c) % conversionFactor

    val dollarsAsString =
      if ((dollars == 0) && isNegative) s"-$dollars" else s"$dollars"

    (dollarsAsString, displayableCents(cents))
  }

  private def displayableCents(cents: Int) = cents match {
    case c if c < 10 => s"0$c"
    case c => s"$c"
  }

  override def toString = {
    val (d, c) = asDollarsAndCents
    s"$$$d.$c"
  }

  def +(other: Money) = Money(asCents + other.asCents)
  def -(other: Money) = Money(asCents - other.asCents)
  def ==(other: Money) = asCents == other.asCents
  def <(other: Money) = asCents < other.asCents

  //  def *(other: Money) = Money(num * other.num, den * other.den)
  //  def /(other: Money) = this * Money(other.den, other.num)
}