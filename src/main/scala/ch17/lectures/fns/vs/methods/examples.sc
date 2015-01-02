def m1(x:Int) = x+3

// Predicted... m1: (Int)Int
// Actual...... m1: m1[](val x: Int) => Int

val f1 = (x:Int) => x+3
// Predicted... f1: (Int) => Int = <function>
// Actual...... f1: Int => Int = <function1>

val f2 = m1 _
// Predicted... f2: (Int) => Int = <function>
// Actual...... f2: Int => Int = <function1>

m1(2)
f1(2)
f2(2)

// Can call additional methods on the functions
f1.toString()
(f1 andThen f2)(5)

// Cannot do this on the m1 method

// A method can be type-parameterized...
def m2[T](x:T) = x.toString.substring(0,4)

m2("abcdefg")
m2(1234567)

// but an anonymous function cannot...

// However, if you are willing to define an explicit class for your function,
// then you can type-parameterize it similarly:

class myfunc[T] extends Function1[T,String] {
  def apply(x:T) = x.toString.substring(0,4)
}

val f5 = new myfunc[String]
f5("abcdefg")
val f6 = new myfunc[Int]
f6(1234567)