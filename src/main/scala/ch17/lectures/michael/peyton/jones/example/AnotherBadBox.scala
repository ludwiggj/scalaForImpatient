package ch17.lectures.michael.peyton.jones.example

/*

(1) Remember classes defined in Family.scala...

    class GrandParent
    class Parent extends GrandParent
    class Child extends Parent

    so...

    Child <: Parent <: GrandParent

(2) Now consider...

    If we declare T as contravariant, the class compiles, but we run into conflict with
    return types later on (see below)...
*/

class AnotherBadBox[-T] {

  def befriend(x: T): T = {
    x
  }
}

/*

(3) Remembering,

    Child <: Parent <: GrandParent

    Thus...

    AnotherBadBox[GrandParent] <: AnotherBadBox[Parent] <: AnotherBadBox[Child]
*/

object Example extends App {
  var myDad: Parent = new Parent()

  def befriendMyDad(box: AnotherBadBox[Parent]): Parent = {
    val itsMyDadAgain: Parent = box.befriend(myDad)
    itsMyDadAgain
  }

  val boxedGrandparent = new AnotherBadBox[GrandParent]
  val boxedParent = new AnotherBadBox[Parent]
  val boxedChild = new AnotherBadBox[Child]

  // (a) This one is disallowed by compiler...

  // Error: type mismatch;
  // found   : AnotherBadBox[Child]
  // required: AnotherBadBox[Parent]

  // itsMyDadYetAgain = befriendMyDad(boxedChild)

  // (b) This one is OK
  var itsMyDadYetAgain: Parent = befriendMyDad(boxedParent)

  // (c) NOTE: This one causes a problem...
  //     This is an example of why compiler has disallowed the definition of AnotherBadBox

  itsMyDadYetAgain = befriendMyDad(boxedGrandparent)
}

/*

(4) Definition of class AnotherBadBox...

    class AnotherBadBox[-T] {

      def befriend(x: T): T = {
        x
      }
    }

    Results in compilation error...

    Error: contravariant type T occurs in covariant position in type (x: T)T of method befriend
      def befriend(x: T): T = {
         ^

(5) Above call (case (c)) demonstrates the problem. The befriend method of boxedGrandparent
    (AnotherBadBox[GrandParent]) is:

    def befriend(x: GrandParent): GrandParent = {
      x
    }

    Therefore when we pass AnotherBadBox[GrandParent] into befriendMyDad:

    def befriendMyDad(box: AnotherBadBox[Parent]): Parent = {
        val itsMyDadAgain: Parent = box.befriend(myDad)
        itsMyDadAgain
    }

    variable itsMyDadAgain (of type Parent) is assigned a value of type GrandParent.

    This is invalid, as Parent <: GrandParent.
*/