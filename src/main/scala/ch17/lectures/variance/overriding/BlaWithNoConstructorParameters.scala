package ch17.lectures.variance.overriding

class Bla
class Fasel extends Bla

trait Test[A] {
 def tester(): Bla = new Bla
}

class FooTest[A] extends Test[A] {
 override def tester(): Fasel = new Fasel
}

object Main extends App {
  new FooTest[Int]().tester()
}