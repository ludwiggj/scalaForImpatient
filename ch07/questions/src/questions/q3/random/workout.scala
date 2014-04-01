//3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and
//setSeed(seed: Int): Unit. To generate random numbers, use the linear
//congruential generator
//next = previous × a + b mod 2n,
//where a = 1664525, b = 1013904223, and n = 32.

package questions.q3.random

object workout extends App {
  setSeed(0)

  for (i <- 1 until 10) {
    println(nextDouble())
  }

  setSeed(0)

  for (i <- 1 until 10) {
    println(nextInt())
  }
}