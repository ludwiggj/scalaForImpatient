// Functions with Function parameters

import scala.math._
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)

val v: ((Double) => Double) => Double = valueAtOneQuarter _

v(exp _)

// Functions that produce functions

def mulBy(factor: Double) = (x: Double) => factor * x

val xFactor: Double => ((Double) => Double) = mulBy _
val triple = mulBy(3)
val quintuple = xFactor(5)
triple(20)
quintuple(12)