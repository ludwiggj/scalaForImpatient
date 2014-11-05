import java.awt.Color

var sign = -6
val ch = '+'

ch match {
  case '+' => sign = 1
  case '-' => sign = -1
  case _ => sign = 0
}

sign

var anotherSign = ch match {
  case '+' => 1
  case '-' => -1
  case _ => 0
}

val color = Color.GRAY

color match {
  case Color.RED => println("RED!")
  case _ => println("Unknown")
}