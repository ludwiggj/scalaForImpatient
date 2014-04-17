package sec03

object AgeReader extends App {
  print("How old are you? ")
  val age = readInt()
  println("Next year, you will be " + (age + 1))
}