class Person {
  var age = 0
}

val fred = new Person
fred.age = 21
println(fred.age)

class Person {
  private var privateAge = 0 // Make private and rename
  def age = privateAge
  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue; // Can’t get younger
  }
}

val fred = new Person
fred.age = 30
fred.age = 21
println(fred.age)