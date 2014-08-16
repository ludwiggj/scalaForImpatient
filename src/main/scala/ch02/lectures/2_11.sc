import scala.io.Source.fromFile
import javax.swing.JOptionPane._

// Produces words: String = <lazy>
lazy val words = fromFile("/a/made/up/file").mkString
// Following statement will force words to be evaluated,
// thus resulting in a FileNotFoundException
// println(words)
println("Defining firstName")
// Dialog box displayed immediately
val firstName = showInputDialog("Your First Name")
println("Printing once")
println(firstName)
println("Printing twice")
println(firstName)
println("Defining lastName")
// Dialog box displayed after 'Printing once'
lazy val lastName = showInputDialog("Your Last Name")
println("Printing once")
println(lastName)
println("Printing twice")
println(lastName)
println("Defining age")
// Dialog box displayed twice
def age = showInputDialog("Your Age")
println("Printing once")
println(age)
println("Printing twice")
println(age)