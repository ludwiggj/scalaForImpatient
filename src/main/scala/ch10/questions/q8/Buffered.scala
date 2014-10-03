package ch10.questions.q8

import java.io.{FileInputStream, BufferedInputStream, InputStream}
import misc.Constants.FILE_ROOT

trait Buffered extends InputStream {
  val bufferedStream = new BufferedInputStream(this)

  override def read(): Int = {
    bufferedStream.read
  }

  override def mark(readLimit: Int) {
    bufferedStream.mark(readLimit)
  }

  override def reset() {
    bufferedStream.reset()
  }

  override def close() {
    bufferedStream.close()
    super.close()
  }
}

object Main extends App {
  val unbufferedInput = new FileInputStream(s"$FILE_ROOT/bob.txt")

  printMaxBytes(unbufferedInput, 5)
  printMaxBytes(unbufferedInput, 7)
  printMaxBytes(unbufferedInput, -1)

  unbufferedInput.close()

  val bufferedInput = new FileInputStream(s"$FILE_ROOT/bob.txt") with Buffered

  printMaxBytes(bufferedInput, 5)
  bufferedInput.mark(50)
  printMaxBytes(bufferedInput, 7)
  bufferedInput.reset()
  printMaxBytes(bufferedInput, -1)

  bufferedInput.close()
}