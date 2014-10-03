import java.io.{FileInputStream, BufferedInputStream}
import ch10.questions.q8.printMaxBytes
import misc.Constants.FILE_ROOT

val bobFile = s"$FILE_ROOT/bob.txt"

// Get all bytes
var stream = new FileInputStream(bobFile)
printMaxBytes(stream, -1)
stream.close()
// Get 5 bytes
stream = new FileInputStream(bobFile)
printMaxBytes(stream, 5)
stream.close()
// Buffered input - print underlying stream, shows no buffering effect
stream = new FileInputStream(bobFile)
var bufferedInput = new BufferedInputStream(stream)
printMaxBytes(stream, 5)
bufferedInput.mark(50)
printMaxBytes(stream, 7)
bufferedInput.reset()
printMaxBytes(stream, -1)
stream.close()
bufferedInput.close()
// Buffered input - print underlying buffered stream, demonstrating buffering effect
stream = new FileInputStream(bobFile)
bufferedInput = new BufferedInputStream(stream)
printMaxBytes(bufferedInput, 5)
bufferedInput.mark(50)
printMaxBytes(bufferedInput, 7)
bufferedInput.reset()
printMaxBytes(bufferedInput, -1)
stream.close()
bufferedInput.close()