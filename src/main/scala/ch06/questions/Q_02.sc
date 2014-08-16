//2. The preceding problem wasn’t very object-oriented. Provide a general superclass
//UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and
//MilesToKilometers that extend it.

class UnitConversion(private val conversionRate: Double) {
  def convert(valueToConvert: Double) = valueToConvert * conversionRate
}
object InchesToCentimeters extends UnitConversion(2.54) {}
object GallonsToLitres extends UnitConversion(3.79) {}
object MilesToKilometers extends UnitConversion(1.61) {}

InchesToCentimeters.convert(1)

GallonsToLitres.convert(1)

MilesToKilometers.convert(3)