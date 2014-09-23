// f: (Int, Int) => Int = <function2>
val f: (Int, Int) => Int = _ + _

f(2, 4)

//g: ((Int, Int)) => Int = <function1>
var g = f.tupled // or

// Scala can interpret following as tuple
g(1, 2)
g = Function.tupled(f)
g((5,8))

// or with a method

//ff: (a: Int, b: Int)Int
def ff(a: Int, b: Int): Int = a + b
ff(6,9)

//gf: ((Int, Int)) => Int = <function1>
var gf = (ff _).tupled
gf(11, 22)

gf = Function.tupled(ff _)
gf(11, 221)

// or inlined
//fff: ((Int, Int)) => Int = <function1>
val fff: ((Int,Int)) => Int = Function.tupled(_ + _)

fff(10, 92)