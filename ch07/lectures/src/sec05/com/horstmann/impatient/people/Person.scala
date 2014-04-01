package sec05.com.horstmann.impatient.people

class Person {
    var name = defaultName // A constant from the package
    def description = "A person with name " + name
}

object Main extends App {
    val john = new Person
    println(john.description)
}