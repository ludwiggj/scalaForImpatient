package examples.fields

class Person {
  var age = 0
  val sex = "Male"
}

//$ javap -p Person
//Compiled from "Person.scala"
//public class Person {
//  private int age;
//  private final java.lang.String sex;
//  public int age();
//  public void age_$eq(int);
//  public java.lang.String sex();
//  public Person();
//}