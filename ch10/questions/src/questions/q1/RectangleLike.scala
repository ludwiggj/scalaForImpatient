package questions.q1

import java.awt.geom.RectangularShape

trait RectangleLike {
  self: RectangularShape =>

  def grow (h: Int, v: Int) = {
    self.setFrame(self.getX - h, self.getY - v, self.getWidth + 2*h, self.getHeight + 2*v)
  }

  def translate (dx: Int, dy: Int) = {
    self.setFrame(self.getX + dx, self.getY + dy, self.getWidth, self.getHeight)
  }

  override def toString() = {
    s"Ellipse: X [${getMinX}] Y [${getMinY}] W [${getWidth}] H [${getHeight}]"
  }

}