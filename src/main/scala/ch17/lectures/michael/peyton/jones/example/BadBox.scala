package ch17.lectures.michael.peyton.jones.example

/*

(1) Remember classes defined in Family.scala...

    class GrandParent
    class Parent extends GrandParent
    class Child extends Parent

    so...

    Child <: Parent <: GrandParent

(2) Definition of functions that take a single parameter is:

    trait Function1[-T1, +R] ...

    The reason why Function1 behaves in this way is a bit subtle, but makes sense if you think about the way
    substitution has to work when you have subtyping. If you have a function from A to B, what can you substitute
    for it?

    i.e. Function1[-A, +B]

    Function1[GrandParent, Child] <: Function1[Parent, Parent]

    Anything you put in its place must make fewer requirements on it’s input type; since the function can’t,
    for example, get away with calling a method that only exists on subtypes of A. On the other hand, it must
    return a type at least as specialised as B, since the caller of the function may be expecting all the
    methods on B to be available.

(3) Now consider...
*/

class BadBox[+T] {
  def befriend(x: T): BadBox[T] = {
    this
  }
}

/*
    Compiler spits out following error...

    Error: covariant type T occurs in contravariant position in type T of value x
        def befriend(x : T) : BadBox[A]
           ^

    So we can now see why we got that cryptic compile error. We declared that T was covariant in our class,
    and also that befriend takes a parameter of type T.

    Then, for some U <: T we could replace an instance of BadBox[T] with an instance of BadBox[U], and
    hence an instance of BadBox[T].befriend(x) with BadBox[U].befriend(x), where x:U.

(4) Remember,

    Child <: Parent <: GrandParent

    So...

    BadBox[Child] <: BadBox[Parent] <: BadBox[GrandParent]
*/

object Example extends App {
  var myDad: Parent = new Parent()

  def befriendMyDad(box: BadBox[Parent]) {
    box.befriend(myDad)
  }

  val boxedGrandparent = new BadBox[GrandParent]
  val boxedParent = new BadBox[Parent]
  val boxedChild = new BadBox[Child]

  // (a) This one is disallowed by compiler...

  // Error: type mismatch;
  // found   : BadBox[GrandParent]
  // required: BadBox[Parent]

  // befriendMyDad(boxedGrandparent)

  // (b) This one is OK
  befriendMyDad(boxedParent)

  // (c) NOTE: This one causes a problem, and is the reason that
  //     the compiler disallows the definition of BadBox
  befriendMyDad(boxedChild)

/*
(5) Above call (case (c)) demonstrates the problem. The befriend method of

    boxedChild (BadBox[Child]) is:

    def befriend(x : Child) : BadBox[Child] = ...

    BUT... befriendMyDad becomes....

    def befriendMyDad(box: BadBox[Child]) {
      box.befriend(new Parent())
    }

    This is not allowed, as befriend method of BadBox[Child] expects a Child, but we're
    attempting to pass it a Parent

(6) Hmm, belt and braces check...
*/

  def talkToLivingParent(x: Parent): Unit = {
   // blah blah...
  }

  talkToLivingParent(new Parent)
  talkToLivingParent(new Child)

  // This one isn't allowed because we're passing a less specific object

  // talkToLivingParent(new GrandParent)

  // Phew!
}