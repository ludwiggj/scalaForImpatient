package ch11.lectures.sec10

object Name {
  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

object Main1 extends App {
  def printAuthor(x: String) {
    x match {
      case Name(first, last) => println(s"Hello $first $last")
      case Name(first, middle, last) => println (s"Greetings $first $middle $last")
      case Name(first, "van", "der", last) => println (s"Salut $first $last")
      case z => println(s"Oy $z; who are you?")
    }
  }

  printAuthor("Cay Horstmann")
  printAuthor("Rip van Winkle")
  printAuthor("Barney van der Waalk")
  printAuthor("Groot")
}