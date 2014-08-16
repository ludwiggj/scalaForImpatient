package ch05.lectures.examples.constructors

class Person2(name: String, age: Int) {
  val description = name + " is " + age + " years old"
}

// description is now preceded by val (instead of def)

/*

$ javap -private ch05.lectures.examples.constructors.Person2
Compiled from "ch05.lectures.examples.constructors.Person2.scala"
public class ch05.lectures.examples.constructors.Person2 implements scala.ScalaObject {
  private final java.lang.String description;
  public java.lang.String description();
  public ch05.lectures.examples.constructors.Person2(java.lang.String, int);
}

*/
