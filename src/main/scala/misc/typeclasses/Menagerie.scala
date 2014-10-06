package misc.typeclasses

object Menagerie extends App {
  val animals = List(new Dog, new Cat)

  for (animal <- animals) {
    println(animal.makeSound)
  }
}