package ch06.lectures.sec05

// Supports scala -Dscala.time option
object Hello extends App {
  if (args.length > 0)
    println("Hello, " + args(0))
  else
    println("Hello, World!")
}

// Does not support scala -Dscala.time option
object Hello1 {
  def main(args: Array[String]) {
    println("Hello, Everyone!")
  }
}