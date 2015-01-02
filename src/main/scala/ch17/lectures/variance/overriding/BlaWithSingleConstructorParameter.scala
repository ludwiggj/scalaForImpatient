package ch17.lectures.variance.overriding

// class Bla
// class Fasel extends Bla

trait Test1[A] {
 def tester(a: Fasel): Bla = new Bla
}

class FooTest1[A](a: A) extends Test1[A] {

 // "This fails even though functions are contravariant in their parameter types..."
 // Error: method tester overrides nothing...
 // NOTE: This is a method, not a function...
 //       As signature is different, this is overloading, not overriding

 // override def tester(a: Bla): Fasel = new Fasel

 // If remove override, now have an overloaded method
 def tester(a: Bla): Fasel = new Fasel

 // This is the correct form of the override. It's OK to return a more specific type...
 override def tester(a: Fasel): Fasel = new Fasel
}

// Note that overriding is not polymorphic in the method's parameter types. So for example:

class A {
  def foo(a : Any) = println("A: " + a)
}

class B extends A {
  // will not compile!
  // override def foo(s : String) = println("B " + s)
}

// The two methods above are two separate methods: dynamic dispatch works only on the method target
// (i.e. the object on which it is being called).