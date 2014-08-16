package ch10.questions.q4

import scala.collection.immutable.NumericRange
import ch10.lectures.sec02.Logger
import ch10.lectures.sec06.ConsoleLogger

trait CryptoLogger extends Logger {
  val key: Int = 3
  val dictionary = zipper('a' to 'z') ++ zipper('A' to 'Z')

  private def zipper(in: NumericRange.Inclusive[Char]): Map[Char, Char] = {
    if (in.isEmpty) Map[Char, Char]()
    else {
      val input = in.toList
      val size = in.size
      val offSet = key % size
      val encoded = if (offSet < 0) {
        (input takeRight offSet.abs) ::: (input take (size - offSet.abs))
      } else {
        (input takeRight (size - offSet)) ::: (input take offSet)
      }
      (input zip encoded).toMap
    }
  }

  abstract override def log(msg: String) {
    // Also an abstract method...
    super.log(encrypt(msg))
  }

  private def encrypt(msg: String): String = {
    for (ch <- msg) yield dictionary.getOrElse(ch, ch)
  }
}

object Main extends App {
  val encryptLogger = new Trojan with ConsoleLogger with CryptoLogger
  encryptLogger.log("This is a test log message")

  val decryptLogger = new {
    override val key = -3
  } with Trojan with ConsoleLogger with CryptoLogger
  decryptLogger.log("Wklv lv d whvw orj phvvdjh")
}