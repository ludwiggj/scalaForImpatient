package ch13.questions

import java.util.concurrent.atomic.AtomicReference

import misc.Constants._

import scala.collection.{SortedMap, mutable, Map}
import scala.io.Source

package object q9 {
  def runInThread(block: => Unit) {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  def countFiles(block: => Unit, noOfThreads: Int) = {
    (1 to noOfThreads) foreach (threadNo =>
      runInThread {
        block
        print(s"Thread $threadNo complete! ")
      }
      )
    Thread.sleep(2000)
  }

  def getBufferedSource() = {
    Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/lectures/mary.txt", "UTF-8")
  }

  def sortMap(m: Map[Char, Int]): SortedMap[Int, mutable.SortedSet[Char]] = {
    var sortedMap = SortedMap[Int, mutable.SortedSet[Char]]()
    for (tup <- m) {
      val sortedSet = sortedMap.getOrElse(tup._2, mutable.SortedSet[Char]())
      sortedMap += tup._2 -> (sortedSet + tup._1)
    }
    sortedMap
  }

  def displayResults(m: Map[Char, Int]) {
    println("\nResults...")
    val total = m.values.sum
    sortMap(m) foreach (println(_))
    println(s"Total $total")
  }
}