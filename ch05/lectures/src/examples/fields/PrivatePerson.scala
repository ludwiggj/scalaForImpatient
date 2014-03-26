package examples.fields

class PrivatePerson {
  private var age = 0
  private val sex = "Male"
}

//$ javap -p PrivatePerson
//Compiled from "PrivatePerson.scala"
//public class PrivatePerson {
//  private int age;
//  private final java.lang.String sex;
//  private int age();
//  private void age_$eq(int);
//  private java.lang.String sex();
//  public PrivatePerson();
//}