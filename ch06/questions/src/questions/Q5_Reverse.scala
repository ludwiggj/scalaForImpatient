//5. Write a Scala application, using the App trait, that prints the command-line
//arguments in reverse order, separated by spaces. For example, scala Reverse
//Hello World should print World Hello.

package questions

object Q5_Reverse extends App {
  println(">" + args.reverse.mkString(" ") + "<")
}