package ch17.lectures.variance.overriding

//class Bla
//class Fasel extends Bla

//trait Test1[A] {
// def tester(a: Fasel): Bla = new Bla
//}
//
//class FooTest1[A](a: A) extends Test1[A] {
// override def tester(a: Bla): Fasel = new Fasel
//}

// Solution 1, using cast
trait Test2[A] {
 def tester(a: Fasel): Bla = new Bla
}

class FooTest2[A] extends Test2[A] {
   override def tester(a: Fasel) : Fasel = test(a.asInstanceOf[Bla])
   def test(a: Bla) : Fasel = new Fasel
}

// Solution 2, using contra-variance
trait Test3[-A] {
  // note the - before A.
  // You might want to constraint with -A >: Fasel
  // NOTE: The seems to run into an error whereby doesn't recognise that tester is being overridden
  def tester(a: A) : Bla = new Bla
}

class FooTest3 extends Test3[Bla] {
  override def tester(a: Bla): Fasel = new Fasel
}

object Main1 extends App {
  val testOfBla: Test3[Bla] = new FooTest3
  val testOfFasel: Test3[Fasel] = testOfBla
}