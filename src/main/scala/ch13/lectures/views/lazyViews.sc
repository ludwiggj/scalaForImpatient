import scala.math.pow

val powers = (0 until 20).view.map(pow(10, _))

powers(5)

powers force

powers

(0 until 20).map(pow(10, _)).map(1 / _)
(0 until 20).view.map(pow(10, _)).map(1 / _).force