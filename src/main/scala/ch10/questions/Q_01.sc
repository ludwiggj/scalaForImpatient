import java.awt.geom.Ellipse2D
import java.awt.Rectangle
import ch10.questions.q1.RectangleLike

val rect = new Rectangle(1, 1, 2, 1)
rect.grow(1, 2)
rect
rect.translate(2, 3)
rect

val egg = new Ellipse2D.Double(1, 1, 2, 1) with RectangleLike

egg.grow(1, 2)
egg

egg.translate(2, 3)
egg