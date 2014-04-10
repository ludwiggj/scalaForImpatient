class Person(val name: String, val age: Int) {
  override def toString = getClass.getName + "[name=" + name +
    ",age=" + age + "]"
}

class Employee(name: String, age: Int, val salary : Double) extends
  Person(name, age) {
  override def toString = super.toString + "[salary=" + salary + "]"
}

new Employee("Fred", 42, 50000)

class Square(x: Int, y: Int, width: Int) extends
  java.awt.Rectangle(x, y, width, width)

new Square(50, 150, 100)