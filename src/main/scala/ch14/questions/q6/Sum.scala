package ch14.questions.q6

sealed abstract class BinaryTree

case class Leaf(value: Int) extends BinaryTree

case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

object Sum {

  def sumLeaf(tree: BinaryTree): Int = {
    tree match {
      case Leaf(x) => x
      case Node(left, right) => sumLeaf(left) + sumLeaf(right)
      case _ => 0
    }
  }
}

import Sum._

object Main extends App {
  val x = Node(Node(Leaf(3), Leaf(8)), Node(Leaf(2), Node(Leaf(5), null)))
  println(x)
  println(sumLeaf(x))
}