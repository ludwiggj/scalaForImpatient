package ch21.lectures.sec07

import java.awt.Point

class Pair[T: Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) =
    if (ord.compare(first, second) < 0) first else second
}

class AnotherPair[T: Ordering](val first: T, val second: T) {
  def smaller =
    if (implicitly[Ordering[T]].compare(first, second) < 0) first else second
}

class OrderedPair[T: Ordering](val first: T, val second: T) {
  def smaller = {
    import Ordered._

    if (first < second) first else second
  }
}

object Main extends App {
  println(new Pair(40, 2).smaller)
  println(new AnotherPair(40, 122).smaller)
  println(new OrderedPair("hello", "graeme").smaller)

  implicit object PointOrdering extends Ordering[Point] {
    def compare(a: Point, b: Point): Int = {
      if (a.getX < b.getX || ((a.getX == b.getX) && (a.getY < b.getY))) -1 else 1
    }
  }

  println(new Pair(new Point(1, 3), new Point(5, 2)).smaller)
  println(new Pair(new Point(7, 3), new Point(7, 2)).smaller)
}