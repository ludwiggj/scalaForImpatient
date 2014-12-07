package ch17.lectures

class Person(val name: String) {
  override def toString = s"Person $name"
}

class Student(name: String) extends Person(name) {
  override def toString = s"Student $name"
}