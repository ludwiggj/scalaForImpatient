package ch10.questions.q2

import java.awt.Point

class OrderedPoint(x: Int = 0, y: Int = 0) extends Point(x, y) with Ordered[Point] {
   def compare(that: Point): Int =
    (x, y) match {
      case (x, y) if ((x < that.getX) || ((x == that.getX) && (y < that.getY))) => -1
      case (x, y) if ((x == that.getX) && (y == that.getY)) => 0
      case _ => 1
    }
}