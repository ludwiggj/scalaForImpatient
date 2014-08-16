//1. Write a code snippet that sets a to an array of n random integers between 0
//(inclusive) and n (exclusive).
import scala.util.Random

def randomArray(n: Int) = {
  Array.fill(n) { Random.nextInt(n) }
}

randomArray(5)
randomArray(10)