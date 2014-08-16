package ch10.questions.q4

import scala.collection.immutable.NumericRange

trait Crypto {
  val key: Int = 3
  val dictionary = zipper('a' to 'z') ++ zipper('A' to 'Z')

  def encrypt(msg: String): String = {
    for (ch <- msg) yield dictionary.getOrElse(ch, ch)
  }

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
}

object CryptoMain extends App {
  def encrypt(encypter: Crypto, msg: String) = {
    val encrypted = encypter.encrypt(msg)
    println(s"$msg => $encrypted")
    encrypted
  }

  val encrypted = encrypt(new Encrypter, "this is a test")

  encrypt(new DuffDecrypter, encrypted)

  encrypt(new Decrypter, encrypted)

  val shiftBy26 = new { override val key = 26 } with Trojan with Crypto
  val shiftByMinus27 = new { override val key = -27 } with Trojan with Crypto

  encrypt(shiftBy26, "hello")
  encrypt(shiftByMinus27, "hello")
}