import scala.language.implicitConversions

/*

Q.

Look through the methods of the Iterable[+A] trait. Which methods use the type parameters A?
Why is it in a covariant position in these methods?

A.

A is only used in the return type e.g.

def head: A, which returns the first element of the collection

Imagine the following situation:
*/

class Animal(val name: String) {
  def gestate() = s"Gestating $name"
  override def toString = s"$name"
}

class Dog(name: String) extends Animal(name) {
}

def gestateFirstAnimal(iter: Iterable[Animal]) = {
  val first: Animal = iter.head
  first.gestate()
}

val zoo = List(new Animal("Giraffe"), new Animal("Hippo"))
gestateFirstAnimal(zoo)

// Now as Dog <: Animal, and Iterable is covariant,
// List[Dog] <: List[Animal]

val pound = List(new Dog("Rover"), new Dog("Jasper"))
gestateFirstAnimal(pound)

// Let's show why the type parameter cannot appear in a contravariant position

class RichList[+A](val list: List[A]) {
  // elem is not allowed in this position

  // def append(elem: A) = elem +: list
  // def appendTake2[T](elem: A) = elem +: list

  // This is allowed, as scala will then set A to be whatever it needs so that it executes
  def appendTake3[A](elem: A) = elem +: list
  override def toString = s"List ${list.mkString(" ")}"
}

object RichList {
  def apply[T](list: List[T]) = new RichList[T](list);
  implicit def list2RichList[T](list: List[T]) = apply(list)
}

import RichList.list2RichList

def addAnAnimal(richList: RichList[Animal]): List[Animal] = List[Animal]()
//{
//  richList.append(new Animal("Cat"))
//}

def addAnAnimalTake3(richList: RichList[Animal]) = {
  richList.appendTake3(new Animal("Cat"))
}

addAnAnimal(zoo)

// Remember, List[Dog] <: List[Animal]

// So I can call:

addAnAnimal(pound)

// But this would add an Animal (Cat) to a list of dogs, which is illegal
// Hence why the append method is not allowed

// This works, see above definition, returns a List[Any]
addAnAnimalTake3(pound)