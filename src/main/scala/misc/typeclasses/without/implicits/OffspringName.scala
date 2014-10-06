package misc.typeclasses.without.implicits

import misc.typeclasses.{Cat, Dog}

trait OffspringName[T] {
  def offspringName(t: T): String
}

object OffspringName {
  def offspringName[T](t: T)(o: OffspringName[T]): String = {
    o.offspringName(t)
  }

  object CatHasOffspringName extends OffspringName[Cat] {
    override def offspringName(cat: Cat) = "Kitty"
  }

  object DogHasOffspringName extends OffspringName[Dog] {
    override def offspringName(dog: Dog) = "Puppy"
  }
}

object Main extends App {
  import OffspringName._
  println(offspringName(new Dog)(DogHasOffspringName))
  println(offspringName(new Cat)(CatHasOffspringName))
}