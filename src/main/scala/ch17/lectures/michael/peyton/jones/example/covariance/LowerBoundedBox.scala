package ch17.lectures.michael.peyton.jones.example.covariance

import ch17.lectures.michael.peyton.jones.example.{Child, Parent, GrandParent}

/*

(1) Remember classes defined in Family.scala...

    class GrandParent
    class Parent extends GrandParent
    class Child extends Parent

    so...

    Child <: Parent <: GrandParent

(2) Now consider...
*/

class Box[+A]

class LowerBoundedBox[+A] {
  def befriend[B >: A](x:B) : Box[B] = {
    new Box()
  }
}

/*

(3) Remember,

    Child <: Parent <: GrandParent

    So...

                Box[Child] <:             Box[Parent] <:             Box[GrandParent]
    LowerBoundedBox[Child] <: LowerBoundedBox[Parent] <: LowerBoundedBox[GrandParent]
*/

object LowerBoundedBoxExample extends App {
  var myDad: Parent = new Parent()

  def befriendMyDad(box: LowerBoundedBox[Parent]) {
    box.befriend(myDad)
  }

  val boxedGrandparent = new LowerBoundedBox[GrandParent]
  val boxedParent = new LowerBoundedBox[Parent]
  val boxedChild = new LowerBoundedBox[Child]

  // (a) This one is disallowed by compiler...

  // Error: type mismatch;
  // found   : LowerBoundedBox[GrandParent]
  // required: LowerBoundedBox[Parent]

  // befriendMyDad(boxedGrandparent)

  // (b) This one is OK
  befriendMyDad(boxedParent)

  // (c) NOTE: This is now solved...
  befriendMyDad(boxedChild)

/*
(4) Above call (case (c)) is now OK. The befriend method of boxedChild (LowerBoundedBox[Child]) is:

    class LowerBoundedBox[Child] {
      def befriend[B >: Child](x:B) : Box[B] = {
        new Box()
      }
    }

    befriendMyDad becomes....

    def befriendMyDad(box: LowerBoundedBox[Child]) {
      box.befriend(new Parent())
    }

    which is fine, because Parent >: Child

*/

}