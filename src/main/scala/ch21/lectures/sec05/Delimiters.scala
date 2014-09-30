package ch21.lectures.sec05

case class Delimiters(left: String, right: String)

object FrenchPunctuation {
  implicit val quoteDelimiters = Delimiters("<-", "->")
  implicit val quoteDelimiter = "{"
}

object Main extends App {
  import FrenchPunctuation.{quoteDelimiters, quoteDelimiter}

  def quote(what: String)(implicit delims: Delimiters) = delims.left + what + delims.right

  println(quote("Hey there!")(Delimiters("<<", ">>")))
  println(quote("Bonjour!"))

  // This works, but left and right must be the same!
  def anotherQuote(what: String)(implicit left: String, right: String) = left + what + right

  println(anotherQuote("Alons-y")("<<", ">>"))
  println(anotherQuote("Booyakasa"))
}