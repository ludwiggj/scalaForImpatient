package misc.typeclasses

case class Box[T](value: T)

object Box extends App {
  new Box(2)
  new Box("Hi")
  new Box(new Box(9))
}