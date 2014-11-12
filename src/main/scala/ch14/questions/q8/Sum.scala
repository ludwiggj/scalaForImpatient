package ch14.questions.q8

sealed abstract class Op {
  val start: Int

  def op(a: Int, b: Int): Int
}

class Plus extends Op {
  override val start: Int = 0

  override def op(a: Int, b: Int): Int = {
    a + b
  }

  override def toString() = "+"
}

class Minus extends Op {
  override val start: Int = 0

  override def op(a: Int, b: Int): Int = {
    a - b
  }

  override def toString() = "-"
}

class Multiply extends Op {
  override val start: Int = 1

  override def op(a: Int, b: Int): Int = {
    a * b
  }

  override def toString() = "*"
}

object Plus {
  def apply() = new Plus()
}

object Minus {
  def apply() = new Minus()
}

object Multiply {
  def apply() = new Multiply()
}

sealed abstract class MathTree

case class Leaf(value: Int) extends MathTree

case class Node(op: Op, children: MathTree*) extends MathTree

object Sum {
  def eval(tree: MathTree): Int = {
    tree match {
      case Leaf(x) => x
      case Node(op, children@_*) => (children map eval).foldLeft(op.start)(op.op)
      case _ => 0
    }
  }

  def displayEval(tree: MathTree): Unit = {
    println(tree)
    println(eval(tree))
  }
}

import Sum._

object Main extends App {
  displayEval(Node(Plus(), Leaf(3), Node(Plus(), Leaf(8), Leaf(18))))
  displayEval(Node(Minus(), Leaf(3), Node(Minus(), Leaf(8), Leaf(18))))
  displayEval(Node(Plus(), Node(Multiply(), Leaf(3), Leaf(8)), Leaf(2), Node(Minus(), Leaf(5))))
}