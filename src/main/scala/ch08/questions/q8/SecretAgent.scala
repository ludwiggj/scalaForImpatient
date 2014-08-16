package ch08.questions.q8

class SecretAgent(codeName: String) extends Person(codeName) {
  override val name = "secret"
  override val toString = "secret"
}

/*

$ javap -p SecretAgent
Warning: Binary file SecretAgent contains ch08.questions.q8.SecretAgent
Compiled from "SecretAgent.scala"

public class ch08.questions.q8.SecretAgent extends ch08.questions.q8.Person {
  private final java.lang.String name;
  private final java.lang.String toString;
  public java.lang.String name();
  public java.lang.String toString();
  public ch08.questions.q8.SecretAgent(java.lang.String);
}

*/