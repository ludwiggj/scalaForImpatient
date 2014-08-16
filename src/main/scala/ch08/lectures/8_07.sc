class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

val alien = new Person("Fred") {
  def greeting = "Greetings, Earthling! My name is Fred."
}

def meet(p: Person{def greeting: String}) {
  println(p.name + " says: " + p.greeting)
}

meet(alien)
/*
error: type mismatch;
   found   : Person
   required: Person{def greeting: String}
                meet(new Person("human"))

 This is a structural type (see chapter 18)
 Obviously not the same type as "Person" !
*/

// meet(new Person("human"))