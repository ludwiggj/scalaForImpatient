package examples.constructors

class Person1(name: String, age: Int) {
  def description = name + " is " + age + " years old"
}

// name and age become object private

/*

$ javap -private examples.constructors.Person1
Compiled from "examples.constructors.Person1.scala"
public class examples.constructors.Person1 implements scala.ScalaObject {
  private final java.lang.String name;
  private final int age;
  public java.lang.String description();
  public examples.constructors.Person1(java.lang.String, int);
}

*/
