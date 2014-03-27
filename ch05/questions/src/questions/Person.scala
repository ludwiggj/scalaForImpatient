package questions

// Again, a doesn't make it into the compiled class file
class Person(a: Int) {
  val age = {
    if (a < 0) 0 else a
  }
}