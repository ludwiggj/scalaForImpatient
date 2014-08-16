package ch10.lectures.sec12


class UnhappyException extends LoggedException {
  override def getMessage() = "arrgh!"
}