package ch05.lectures.examples.constructors

class Person1(name: String, age: Int) {
  def description = name + " is " + age + " years old"
}

// name and age become object private

/*

$ javap -private ch05.lectures.examples.constructors.Person1
Compiled from "ch05.lectures.examples.constructors.Person1.scala"
public class ch05.lectures.examples.constructors.Person1 implements scala.ScalaObject {
  private final java.lang.String name;
  private final int age;
  public java.lang.String description();
  public ch05.lectures.examples.constructors.Person1(java.lang.String, int);
}

*/
