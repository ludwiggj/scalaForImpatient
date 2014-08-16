package ch05.lectures.examples.nested.take1

import scala.collection.mutable.ArrayBuffer

class Network(val name: String) { outer =>
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
    def description = name + " inside " + outer.name + " contacts [" + (for (m <- contacts) yield (m.name + " ")) + "]"
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object Main extends App {
  val chatter = new Network("Chatter")
  val myFace = new Network("MyFace")

  val fred = chatter.join("Fred")
  println(fred.description);

  val wilma = chatter.join("Wilma")
  println(fred.description);

  val barney = myFace.join("Barney")
  println(barney.description);

  fred.contacts += wilma
  println(fred.description);

  // fred.contacts += barney  // Not allowed, type mismatch...
  // Can’t add a myFace.Member to a buffer of chatter.Member elements
}