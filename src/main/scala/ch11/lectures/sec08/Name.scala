package ch11.lectures.sec08

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}

object Main1 extends App {
  val author = "Cay Horstmann"
  val Name(first, last) = author
  println(s"Hello, [$first] [$last]")
}