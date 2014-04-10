// Overriding with a val

 class Person(val name: String) {
   override def toString = getClass.getName + "[name=" + name + "]"
   var dummy: String = "dummy"
}

class SecretAgent(codename: String) extends Person(codename) {
//  A val can only override another val or a parameterless def.
  override val name = "secret"     // Override a val with a val; Don’t want to reveal name . . .
  override val toString = "secret" // Override a def with a val; . . . or class name

  // Not allowed by the language: see https://issues.scala-lang.org/browse/SI-899
  // def blowCover = super.name

  // This is allowed, but the name is still protected
  def blowCover = super.toString

//  override val dummy = "override"  // Not allowed to override var with a val
}
val fred = new Person("Fred")
fred.name
val james = new SecretAgent("007")
james.name
james.asInstanceOf[Person].name // Name is still a secret!

james.blowCover

