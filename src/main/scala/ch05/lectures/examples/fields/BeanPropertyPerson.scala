package examples.fields

import scala.reflect.BeanProperty

class BeanPropertyPerson {
  @BeanProperty var age = 0
  @BeanProperty val sex = "Male"
}

/*
$ javap -p BeanPropertyPerson.class
Compiled from "BeanPropertyPerson.scala"
public class BeanPropertyPerson {
  private int age;
  private final java.lang.String sex;
  public int age();
  public void age_$eq(int);
  public void setAge(int);
  public java.lang.String sex();
  public int getAge();
  public java.lang.String getSex();
  public BeanPropertyPerson();
}
*/