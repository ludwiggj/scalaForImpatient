package ch13.questions.q9

object FileLetterCounterImmutableSynchronized {

  var frequencies = Map[Char, Int]()

  private def update(ch: Char): Unit = synchronized {
    frequencies += (ch -> (frequencies.getOrElse(ch, 0) + 1))
  }

  def readFile() = {
    val source = getBufferedSource()
    val iter = source.buffered
    while (iter.hasNext) {
      update(iter.next)
    }
    source.close()
  }
}

object FileLetterCounterImmutableSynchronizedMain extends App {

  import FileLetterCounterImmutableSynchronized._

  println("Immutable map (synchronised) results...")
  countFiles({ readFile() }, 100)
  displayResults(frequencies)
}