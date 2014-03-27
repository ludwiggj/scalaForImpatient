//8. Make a class Car with read-only properties for manufacturer, model name,
//and model year, and a read-write property for the license plate. Supply four
//constructors. All require the manufacturer and model name. Optionally,
//model year and license plate can also be specified in the constructor. If not,
//the model year is set to -1 and the license plate to the empty string. Which
//constructor are you choosing as the primary constructor? Why?

class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licence: String = "") {

  def this(_manufacturer: String, _modelName: String, _modelYear: Int) = {
    this(manufacturer=_manufacturer, modelName = _modelName, modelYear = _modelYear)
  }

  def this(_manufacturer: String, _modelName: String, _licence: String) = {
    this(manufacturer=_manufacturer, modelName = _modelName, licence = _licence)
  }
  def describe = println(s"A $manufacturer $modelName, built in $modelYear, registration $licence")
}
(new Car("Ford", "Fiesta", 1993, "Y265LDX")).describe
val skoda = new Car("Skoda", "Fabia", 2001)
skoda.describe
skoda.licence = "Y253FOO"
skoda.describe
(new Car("Renault", "Scenic", "Y854UBP")).describe
(new Car("Fiat", "Panda")).describe