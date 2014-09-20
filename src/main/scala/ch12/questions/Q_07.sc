val pairs = (1 to 10) zip (11 to 20)

// Following does not compile...
// pairs map (_ + _)

def adjustToPair(fun: (Int,Int) => Int): ((Int, Int)) => Int = {
  fun.tupled
}

adjustToPair(_ * _)((6, 7))

pairs map adjustToPair(_ + _)