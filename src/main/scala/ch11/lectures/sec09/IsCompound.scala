package ch11.lectures.sec09

import ch11.lectures.sec08.Name

object IsCompound {
  def unapply(input: String): Boolean = input.contains(" ")
}

object Main1 extends App {
  def printSurname(x: String) {
    x match {
      case Name(first, last@IsCompound()) => println(s"Compound surname [$last]")
      case Name(first, last) => println (s"Normal surname [$last]")
      case _ => println("No match")
    }
  }

  printSurname("Cay Horstmann")
  printSurname("Rip van Winkle")
  printSurname("Groot")
}