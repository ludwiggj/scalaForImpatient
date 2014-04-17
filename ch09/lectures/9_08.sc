import java.io._
import scala.collection.mutable.ArrayBuffer

class Person(val name: String) extends Serializable {
  val friends = new ArrayBuffer[Person]
  // OK—ArrayBuffer is serializable
  def description = name + " with friends " +
    friends.map(_.name).mkString(", ")
}

val fred = new Person("Fred")
val wilma = new Person("Wilma")
val barney = new Person("Barney")
fred.friends += wilma
fred.friends += barney
wilma.friends += barney
barney.friends += fred

println("Fred before saving...")
fred.description
fred.friends.map(_.description)


val out = new ObjectOutputStream(new FileOutputStream("./ch09/lectures/test.obj"))
out.writeObject(fred)
out.close()


val in = new ObjectInputStream(new FileInputStream("./ch09/lectures/test.obj"))
val savedFred = in.readObject().asInstanceOf[Person]
in.close()

println("Fred after reconstituting...")
savedFred.description
savedFred.friends.map(_.description)

