package ch17.lectures.michael.peyton.jones.example.contravariance

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

class UpperBoundedBox[-A] {
  def befriend[B <: A](x:B) : Box[B] = {
    new Box()
  }
}

/*

(3) Remember,

    Child <: Parent <: GrandParent

    So...

                      Box[Child] <:             Box[Parent] <:             Box[GrandParent]
    UpperBoundedBox[GrandParent] <: UpperBoundedBox[Parent] <: UpperBoundedBox[Child]
*/

object UpperBoundedBoxExample extends App {
  var myDad: Parent = new Parent()

  def befriendMyDad(box: UpperBoundedBox[Parent]) {
    box.befriend(myDad)
  }

  val boxedGrandparent = new UpperBoundedBox[GrandParent]
  val boxedParent = new UpperBoundedBox[Parent]
  val boxedChild = new UpperBoundedBox[Child]

  // (a) This one is solved
  befriendMyDad(boxedGrandparent)

  // (b) This one is OK
  befriendMyDad(boxedParent)

  // (c) This one is disallowed by compiler...

  // Error: type mismatch;
  // found   : UpperBoundedBox[Child]
  // required: UpperBoundedBox[Parent]

  // befriendMyDad(boxedChild)

/*
(4) Above call (case (a)) has been fixed. The befriend method of boxedGrandparent (UpperBoundedBox[GrandParent]) is:

    class UpperBoundedBox[GrandParent] {
      def befriend[B <: GrandParent](x:B) : Box[B] = {
        new Box()
      }
    }

    befriendMyDad becomes....

    def befriendMyDad(box: UpperBoundedBox[GrandParent]) {
      box.befriend(new Parent())
    }

    which is fine, because Parent <: GrandParent

*/

}