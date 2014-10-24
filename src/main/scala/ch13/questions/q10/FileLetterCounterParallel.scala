package ch13.questions.q10

import misc.Constants._
import scala.collection.mutable
import ch13.questions.q9._

import scala.io.Source

object FileLetterCounterParallel extends App {

  val contents = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/lectures/mary.txt", "UTF-8").mkString

  def doesNotWork() = {
    val frequencies = new mutable.HashMap[Char, Int]
    for (c <- contents.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1

    Thread.sleep(1000)
    println("Does not work...")
    displayResults(frequencies)
  }

  def doesWork() = {
    def updateCountByOne(map: Map[Char, Int], ch: Char) = {
      var frequencies = map
      frequencies += (ch -> (frequencies.getOrElse(ch, 0) + 1))
      frequencies
    }

    def updateCount(map: Map[Char, Int], charCount: (Char, Int)) = {
      var frequencies = map
      val (ch, count) = charCount
      frequencies += (ch -> (frequencies.getOrElse(ch, 0) + count))
      frequencies
    }

    val uniqueChars =
      contents.par.aggregate(Map[Char, Int]())((map, ch) => {
        updateCountByOne(map, ch)
      }, _.foldLeft(_)(updateCount(_, _)))
    Thread.sleep(1000)
    println("Does work...")
    displayResults(uniqueChars)
  }

  doesNotWork()
  doesWork()
}