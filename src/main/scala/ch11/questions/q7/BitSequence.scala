package ch11.questions.q7

class BitSequence {
  var data: Long = 0

  override def toString = {
    (for (i <- 63 to(0, -1)) yield nthBit(i)).mkString
  }

  def apply(n: Int) = {
    if (indexIsInRange(n)) nthBit(n)
    else 0L
  }

  def update(index: Int, newValue: Int) = {
    if (indexIsInRange(index)) {
      if (newValue == 0) data &= ~bitMask(index)
      else data |= bitMask(index)
    }
  }

  private def nthBit(i: Int): Long = {
    (data >> i) & 1L
  }

  private def indexIsInRange(index: Int) = (index >= 0 && index <= 63)

  private def bitMask(index: Int) = 1L << index

  def dump = {
    println(s"dump value: $data")
    for (i <- 2 to (0, -1)) println(data >> i)
  }

  def dump2 = {
    println(s"dump2 value: $data")
    for (i <- 2 to (0, -1)) println(nthBit(i))
  }
}

object Main extends App {
  val bs = new BitSequence()
  bs(0) = 1
  bs(2) = 1
  bs.dump
  bs.dump2
}