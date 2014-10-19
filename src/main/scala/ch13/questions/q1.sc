import scala.collection.mutable

def indexes(str: String):mutable.Map[Char, mutable.Set[Int]] = {
  (mutable.Map[Char, mutable.Set[Int]]() /: str.zipWithIndex) {
    (m, c) => {
      val (ch, idx) = c
      val setToUpdate = m.getOrElse(ch, mutable.Set[Int]())
      m += (ch -> (setToUpdate += idx))
    }
  }
}

def indexesSorted(str: String):mutable.Map[Char, mutable.SortedSet[Int]] = {
  (mutable.Map[Char, mutable.SortedSet[Int]]() /: str.zipWithIndex) {
    (m, c) => {
      val (ch, idx) = c
      val setToUpdate = m.getOrElse(ch, mutable.SortedSet[Int]())
      m += (ch -> (setToUpdate += idx))
    }
  }
}

indexes("Mississippi")
indexesSorted("Mississippi")