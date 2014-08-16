package ch08.questions.q9

class Creature {
  val range: Int = 10
//  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

object Creature extends App {
  private val creature: Creature = new Creature
  println(creature.range)
  println(creature.env.length)
}