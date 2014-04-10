class Person(val name: String, var age: Int) {
  private var realCodeName = "excelsior"
  def codeName = s"${getClass.getName} [name=$name, age=$age, realCodeName=$realCodeName]"
  def codeName_=(newName: String) { realCodeName = newName }
}

class SecretAgent(codename: String, age: Int) extends Person(codename, age) {
//  override var name = "secret"  // Cannot override a val with a var
  override var codeName = "secret" // Can only override a def with a var if it has getter & setter, as above
  //override var age = 0          // Cannot override a var with a var,
                                  // unless superclass var is abstract
                                  // See 8_09.sc!
}
val bob = new Person("Bob", 17)
bob.name
bob.age
bob.codeName
val fred = new SecretAgent("Fred", 25)
fred.name
fred.age
fred.codeName



