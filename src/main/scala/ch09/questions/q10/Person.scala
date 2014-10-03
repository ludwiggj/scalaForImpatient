package ch09.questions.q10

//10. Expand the example with the serializable Person class that stores a collection
//    of friends. Construct a few Person objects, make some of them friends of
//    another, and then save an Array[Person] to a file. Read the array back in and
//    verify that the friend relations are intact.

import java.io._
import misc.Constants.FILE_ROOT
import scala.collection.mutable.ArrayBuffer

class Person(val name: String) extends Serializable {
  val friends = new ArrayBuffer[Person]
  // OK—ArrayBuffer is serializable
  def description = name + " with friends " +
    friends.map(_.name).mkString(", ")
}

object Main extends App {

  val fred = new Person("Fred")
  val wilma = new Person("Wilma")
  val barney = new Person("Barney")
  val dino = new Person("Dino")

  fred.friends += wilma
  fred.friends += barney
  wilma.friends += barney
  barney.friends += fred
  dino.friends ++= ArrayBuffer(fred, wilma, barney)

  println("Friends before saving...")
  val circleOfFriends = Array(fred, wilma, barney, dino)
  for (p <- circleOfFriends) println(p.description)
  val out = new ObjectOutputStream(new FileOutputStream(s"$FILE_ROOT/src/main/scala/ch09/questions/09_people.obj"))
  out.writeObject(circleOfFriends)
  out.close()
  val in = new ObjectInputStream(new FileInputStream(s"$FILE_ROOT/src/main/scala/ch09/questions/09_people.obj"))
  val reconstituted = in.readObject().asInstanceOf[Array[Person]]
  in.close()
  println("Reconstituted friends...")
  for (p <- reconstituted) println(p.description)
}