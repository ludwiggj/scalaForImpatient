//6. Define an abstract class Shape with an abstract method centerPoint and subclasses
//   Rectangle and Circle. Provide appropriate constructors for the subclasses and
//   override the centerPoint method in each subclass.

class Point(val x: Double, val y: Double) {
  override def toString = s"Point ($x, $y)"
}

abstract class Shape {
  def centrePoint: Point
}

class NonRotatedRectangle(val bottomLeft: Point, val topRight: Point) extends Shape {
  override val centrePoint = {
    new Point((bottomLeft.x + topRight.x)/2, (bottomLeft.y + topRight.y)/2)
  }
}

val r = new NonRotatedRectangle(new Point(1, 1), new Point(3,3))
r.centrePoint

class Circle(val centrePoint: Point, val radius: Double) extends Shape

val c = new Circle(new Point(5,3), 4.0)
c.centrePoint