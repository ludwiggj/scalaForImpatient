package ch13.lectures.seqs

class ListSums {
  def doSums() = {

    val a = 9 :: List(4, 2)

    def sum(lst: List[Int]): Int =
      if (lst == Nil) 0 else lst.head + sum(lst.tail)

    def sum2(lst: List[Int]): Int = lst match {
      case Nil => 0
      case h :: t => h + sum2(t)
    }

    println(sum(a))
    println(sum2(a))
    println(a.sum)
  }
}

object Main extends App {
  new ListSums().doSums()
}