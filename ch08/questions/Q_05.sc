//5. Design a class Point whose x and y coordinate values can be provided in a
//   constructor. Provide a subclass LabeledPoint whose constructor takes a label
//   value and x and y coordinates, such as
//   new LabeledPoint("Black Thursday", 1929, 230.07)

class Point(val x: Double, val y: Double) {
  override def toString = s"Point ($x, $y)"
}

class LabelledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
  override def toString = s"LabelledPoint ($x, $y), $label"
}

new Point(2, 5)
new LabelledPoint("On y axis", 0, 6)

