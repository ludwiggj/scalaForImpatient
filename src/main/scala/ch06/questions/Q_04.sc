//4. Define a Point class with a companion object so that you can construct Point
//instances as Point(3, 4), without using new.

class Point(val x: Int, val y: Int) {
  override def toString = s"Point [$x, $y]"
}

object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

new Point(2, 3)
Point(2, 3)
Array(Point(1,1), Point(2,2))