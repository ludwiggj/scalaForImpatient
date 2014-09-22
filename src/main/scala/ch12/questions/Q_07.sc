val pairs = (1 to 10) zip (11 to 20)


// Following does not compile...
// pairs map (_ + _)

def adjustToPair(f: (Int, Int) => Int): ((Int, Int)) => Int = {
  f.tupled
}

adjustToPair(_ * _)((6, 7))

pairs map adjustToPair(_ + _)


def adjustToPair2(f: (Int, Int) => Int) = {
  (x: (Int, Int)) => f(x._1, x._2)
}

adjustToPair2(_ * _)((6, 7))