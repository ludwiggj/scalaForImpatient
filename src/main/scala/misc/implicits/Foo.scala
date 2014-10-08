package misc.implicits

trait Foo {
  def bar
}

trait Base {
  def callBar(implicit foo: Foo) =
    // foo is supplied implicitly
    foo.bar
}

object Test extends Base {
  // f is function that takes a Foo (implicitly)
  val f: Foo => Unit = { implicit foo =>
    // calls callBar on Base trait (which Test extends)
    callBar
  }

  def test = f(new Foo {
    def bar = println("Hello")
  })
}

object Testy extends Base {
  // This time argument is not declared with implicit
  val f: Foo => Unit = { foozy =>
    // So have to make it implict here...
    implicit val foo = foozy
    callBar
  }

  def test = f(new Foo {
    def bar = println("Hello-ey")
  })
}

object Main1 extends App {
  Test.test
  Testy.test
}