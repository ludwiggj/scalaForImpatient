package ch05.lectures.examples.fields

class ObjectPrivatePerson {
  private[this] var age = 0
  private[this] val sex = "Male"
}

//$ javap -p ObjectPrivatePerson
//Compiled from "ObjectPrivatePerson.scala"
//public class ObjectPrivatePerson {
//  private int age;
//  private final java.lang.String sex;
//  public ObjectPrivatePerson();
//}