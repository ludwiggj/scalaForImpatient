//1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
//milesToKilometers.

object Conversions {
  def inchesToCentimeters(inches: Double) = inches * 2.54
  def gallonsToLitres(gallons: Double) = gallons * 3.79
  def milesToKilometers(miles: Double) = miles * 1.61
}
Conversions.inchesToCentimeters(1)
Conversions.gallonsToLitres(1)
Conversions.milesToKilometers(3)