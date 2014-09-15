// Parameter inference

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

valueAtOneQuarter((x:Double) => 4 * x)
valueAtOneQuarter((x) => 5 * x)

// Because valueAtOneQuarter only has one parameter, we can write...
valueAtOneQuarter(x => 6 * x)

// And because x only appears once on right hand side...
valueAtOneQuarter(7 * _)

// Let's see if these work...

val fun1 = 3 * (_: Double) // OK
fun1(2)

val fun2: (Double) => Double = 4 * _ // OK
fun2(4.5)

val fun3 = 3 * _ // error, can't infer type of _
fun3(3)