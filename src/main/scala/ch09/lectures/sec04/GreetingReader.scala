package ch09.lectures.sec04

import scala.io.Source

object GreetingReader extends App {
  println("What is your name?")
  val source3 = Source.stdin
    // Reads fromb standard input
  println("Hello, " + source3.getLines.next)
}