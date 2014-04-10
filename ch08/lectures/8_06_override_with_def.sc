// A def can only override another def.

class Person(val name: String, var age: Int) {
  override def toString = s"${getClass.getName} [name=$name, age=$age]"
}

class SecretAgent(codename: String, age: Int) extends Person(codename, age) {
  // override def name = "secret"  // Cannot override a val with a def
  override def toString = "secret" // Override a def with a def
  // override def age = 0          // Cannot override a var with a def
}
val bob = new Person("Bob", 17)
bob.name
bob.age
val fred = new SecretAgent("Fred", 25)
fred.name
fred.age