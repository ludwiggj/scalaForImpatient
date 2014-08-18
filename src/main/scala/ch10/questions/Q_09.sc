import ch10.lectures.sec03.ConsoleLogger
import java.io.FileInputStream
import ch10.questions.q8.{Buffered, getMaxBytes}

// Buffered input - print underlying buffered stream, demonstrating buffering effect
val bufferedInput = new FileInputStream("bob.txt") with Buffered with ConsoleLogger


bufferedInput.log(getMaxBytes(bufferedInput, 5))
bufferedInput.mark(50)
bufferedInput.log(getMaxBytes(bufferedInput, 7))
bufferedInput.reset()
bufferedInput.log(getMaxBytes(bufferedInput, -1))

bufferedInput.close()