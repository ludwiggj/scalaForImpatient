package ch14.questions.q7

sealed abstract class NTree

case class Leaf(value: Int) extends NTree

case class Node(children: NTree*) extends NTree

object Sum {

  def sumLeaf(tree: NTree): Int = {
    tree match {
      case Leaf(x) => x
      case Node(children @ _*) => (children map sumLeaf).sum
      case _ => 0
    }
  }
}

import Sum._

object Main extends App {
  val x = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(15)))
  println(x)
  println(sumLeaf(x))
}