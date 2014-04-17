package sec04

import scala.io.Source

object GreetingReader extends App {
  println("What is your name?")
  val source3 = Source.stdin
    // Reads from standard input
  println("Hello, " + source3.getLines.next)
}