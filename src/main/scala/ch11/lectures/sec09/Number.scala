package ch11.lectures.sec09

object Number {
  def unapply(input: String): Option[Int] =
  try {
    Some(Integer.parseInt(input.trim))
  } catch {
    case ex: NumberFormatException => None
  }
}

object Main extends App {
  val Number(n) = "1726"
  println(n)
}