//9. Write a program that imports the java.lang.System class, reads the user name
//from the user.name system property, reads a password from the Console object,
//and prints a message to the standard error stream if the password is not
//"secret". Otherwise, print a greeting to the standard output stream. Do not use
//any other imports, and do not use any qualified names (with dots).

package ch07.questions.q9

object Greeter extends App {
  import java.lang.System._
  val cons = console
  if (cons != null) {
    val passwd = (cons.readPassword("[%s]", "Password:"))
    if (passwd.mkString == "secret") {
      val userName = System.getProperty("user.name")
      out.println(s"Hello $userName")
    } else {
      err.println("That's not the password!")
    }
  } else {
    println("No console!")
  }
}