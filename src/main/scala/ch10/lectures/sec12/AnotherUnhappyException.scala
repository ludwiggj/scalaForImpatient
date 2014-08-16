package ch10.lectures.sec12

import java.io.IOException

class AnotherUnhappyException extends IOException with LoggedException {
  override def getMessage() = "arrghy!"
}