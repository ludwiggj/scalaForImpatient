import scala.math._

def power(x: Int, n: Int): Float = {
    def isEven(x: Int) = {
      x % 2 == 0
    }

    n match {
      case a if a < 0 => 1 / power(x, -n)
      case 0 => 1
      case 1 => x
      case a if isEven(a) => power(x, n/2) * power (x, n/2)
      case _ => x * power(x, n-1)
    }
}

power(2, -4)
power(2, -3)
power(2, -2)
power(2, -1)
power(2, 0)
power(2, 1)
power(2, 2)
power(2, 3)
power(2, 4)