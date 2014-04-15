package questions.q8

class Person(val name: String) {
  override def toString = getClass.getName + "[name =" + name + "]"
}

/*

$ javap -p Person
Warning: Binary file Person contains questions.q8.Person
Compiled from "Person.scala"

public class questions.q8.Person {
  private final java.lang.String name;
  public java.lang.String name();
  public java.lang.String toString();
  public questions.q8.Person(java.lang.String);
}

*/