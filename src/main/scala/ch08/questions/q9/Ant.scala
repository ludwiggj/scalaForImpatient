package ch08.questions.q9

class Ant extends Creature {
  override val range = 2
//  override def range = 2
}

object Ant extends App {
  private val ant: Ant = new Ant
  println(ant.range)
  println(ant.env.length)
}