package misc.typeclasses.using.implicits

import misc.typeclasses.{Animal, Cat, Dog}

trait OffspringName[T] {
  def offspringName(t: T): String
}

object OffspringName {
  def offspringName[T](t: T)(implicit o: OffspringName[T]): String = {
    o.offspringName(t)
  }

  def offspringyName[T: OffspringName](t: T): String = {
    implicitly[OffspringName[T]].offspringName(t)
  }

  implicit class OffspringNameOp[T: OffspringName](t: T) {
    def offspring: String = offspringName(t)
  }

  implicit object CatHasOffspringName extends OffspringName[Cat] {
    override def offspringName(cat: Cat) = "Kitty"
  }

  implicit object DogHasOffspringName extends OffspringName[Dog] {
    override def offspringName(dog: Dog) = "Puppy"
  }

}

object Main extends App {

  import OffspringName._

  private val dog = new Dog
  private val cat = new Cat

  println(offspringName(dog))
  println(offspringName(cat))

  val catAnimal: Animal = cat

  println(cat.makeSound)
  println(catAnimal.makeSound)

  println(offspringName(cat))
  println(offspringyName(cat))

  println(cat.offspring)
  println(dog.offspring)

  // Following line will not compile...
  // Error: could not find implicit value for parameter o: misc.typeclasses.using.implicits.OffspringName
  // [misc.typeclasses.Animal]

  // println(offspringName(catAnimal))
}