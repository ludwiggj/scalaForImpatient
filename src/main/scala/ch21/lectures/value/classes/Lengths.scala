package ch21.lectures.value.classes

object Lengths {

  implicit class Metre(val value: Double) extends AnyVal {
    def toMetres = s"$value metres"
  }

  implicit class Centimetre(val value: Double) extends AnyVal {
    def toMetres = s"${value/100} metres"
  }
}