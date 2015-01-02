package ch17.questions.q4

import ch17.lectures.{Student, Person}

// Q4: Why don't we need a lower bound for the replaceFirst method below, if we want
//     to replace the first component of a Pair[Person] with a Student?

// Answer: T is Person, and Student <: Person

class Pair[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
  override def toString = s"($first, $second)"
}

object Main extends App {
  val pair = new Pair(new Person("p1"), new Person("p2"))
  println(pair)
  val newPair = pair.replaceFirst(new Student("s1"))
  println(newPair)
}