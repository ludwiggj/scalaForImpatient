def f(x: Double) = if (x >= 0) Some(Math.sqrt(x)) else None
def g(x: Double) = if (x != 1) Some(1 / (x-1)) else None

def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
  def composed(x: Double): Option[Double] = {
    for (fVal <- f(x); gVal <- g(x)) yield (gVal)
  }
 composed _
}

def composeCompact(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
  (x: Double) => {
    for (fVal <- f (x);
    gVal <- g (x) ) yield (gVal)
  }
}

def composeAgain(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
  def composed(x: Double): Option[Double] = {
    f(x) match {
      case Some(_) => g(x)
      case _ => None
    }
  }
 composed _
}

def composeAgainCompact(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
  (x: Double) => {
    f(x) match {
      case Some(_) => g(x)
      case _ => None
    }
  }
}

val h = compose(f, g)

h(3)
h(1)
h(0)
h(-1)

val i = composeCompact(f, g)

i(3)
i(1)
i(0)
i(-1)

val j = composeAgain(f, g)

j(3)
j(1)
j(0)
j(-1)

val k = composeAgainCompact(f, g)

k(3)
k(1)
k(0)
k(-1)