//3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and
//setSeed(seed: Int): Unit. To generate random numbers, use the linear
//congruential generator
//next = previous × a + b mod 2n,
//where a = 1664525, b = 1013904223, and n = 32.

package questions.q3

package object random {
  private val a = 1664525
  private val b = 1013904223
  private val n = 32
  private var value = 0d

  def setSeed(seed: Int) = {
    value = seed
  }

  def nextDouble() = {
    nextVal
  }

  def nextInt() = {
    nextVal.toInt
  }

  private def nextVal = {
    value = (value * a) + (b % 2*n)
    value
  }
}