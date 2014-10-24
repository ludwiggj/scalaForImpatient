package ch13.questions.q9

import scala.collection.mutable
import scala.collection.JavaConversions.mapAsScalaConcurrentMap

object FileLetterCounter {

  def readFile(frequencies: mutable.Map[Char, Int], record: (mutable.Map[Char, Int], Char) => Unit) = {
    val source = getBufferedSource()
    val iter = source.buffered
    while (iter.hasNext) {
      val nextCh = iter.next
      record(frequencies, nextCh)
    }
    source.close()
  }

  def update(frequencies: mutable.Map[Char, Int], ch: Char) = {
    frequencies(ch) = frequencies.getOrElse(ch, 0) + 1
  }

  def updateSynchronized(frequencies: mutable.Map[Char, Int], ch: Char) = synchronized {
    update(frequencies, ch)
  }
}

object FileLetterCounterMain extends App {

  import FileLetterCounter._

  val noOfThreads = 250

  val frequencies = new mutable.HashMap[Char, Int] with mutable.SynchronizedMap[Char, Int]

  println("mutable.HashMap with mutable.SynchronizedMap (unsynchronized) ...")

  countFiles({ readFile(frequencies, update) }, noOfThreads)
  displayResults(frequencies)

  frequencies.clear()

  println("mutable.HashMap with mutable.SynchronizedMap (synchronized) ...")

  countFiles({ readFile(frequencies, updateSynchronized) }, noOfThreads)
  displayResults(frequencies)

  val frequencies2: scala.collection.concurrent.Map[Char, Int] =
    new java.util.concurrent.ConcurrentHashMap[Char, Int]()

  println("concurrent.Map from concurrent.ConcurrentHashMap (unsynchronized) ...")

  countFiles({ readFile(frequencies2, update) }, noOfThreads)
  displayResults(frequencies2)

  frequencies2.clear()

  println("concurrent.Map from concurrent.ConcurrentHashMap (synchronized) ...")

  countFiles({ readFile(frequencies2, updateSynchronized) }, noOfThreads)
  displayResults(frequencies2)
}