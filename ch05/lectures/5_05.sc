import scala.reflect.BeanProperty

class Person {
  @BeanProperty var name : String = "Unknown" // = _ for null initial value
}
val fred = new Person
fred.getName
fred.setName("Fred")

fred.getName

