import scala.collection.immutable.SortedSet

def indexes(str: String):Map[Char, Set[Int]] = {
  (Map[Char, Set[Int]]() /: str.zipWithIndex) {
    (m, c) => {
      val (ch, idx) = c
      val setToUpdate = m.getOrElse(ch, Set[Int]())
      m + (ch -> (setToUpdate + idx))
    }
  }
}

def indexesSorted(str: String):Map[Char, SortedSet[Int]] = {
  (Map[Char, SortedSet[Int]]() /: str.zipWithIndex) {
    (m, c) => {
      val (ch, idx) = c
      val setToUpdate = m.getOrElse(ch, SortedSet[Int]())
      m + (ch -> (setToUpdate + idx))
    }
  }
}

indexes("Mississippi")
indexesSorted("Mississippi")