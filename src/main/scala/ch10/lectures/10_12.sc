import ch10.lectures.sec04.ConsoleLogger
import ch10.lectures.sec12.{LoggedException, UnhappyException}

/*
// Following is illegal...

import javax.swing.JFrame

class DuffUnhappyException extends JFrame with LoggedException {
  override def getMessage() = "arrgh!"
}
 */

val unhappyException = new UnhappyException()

unhappyException.log("Unhappy exception")
unhappyException.log()

val unhappyException1 = new UnhappyException() with ConsoleLogger

unhappyException1.log("Unhappy exception with ConsoleLogger")
unhappyException1.log()