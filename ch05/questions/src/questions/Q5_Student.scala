//5. Make a class Student with read-write JavaBeans properties name (of type String)
//and id (of type Long). What methods are generated? (Use javap to check.) Can
//you call the JavaBeans getters and setters in Scala? Should you?

package questions

import scala.reflect.BeanProperty

class Student(@BeanProperty var name : String, @BeanProperty var id : Long) {

}

object Student extends App {
  private def displayStudentDetails(name: String, id: Long) = {
    println(s"Student name [$name] id [$id]")
  }

  val s = new Student("Graeme", 123)

  displayStudentDetails(s.name, s.id)
  displayStudentDetails(s.getName, s.getId)

  s.setName("Burt")
  s.setId(999)

  displayStudentDetails(s.getName, s.getId)
}