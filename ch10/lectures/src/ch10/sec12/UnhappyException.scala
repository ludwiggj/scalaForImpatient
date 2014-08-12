package ch10.sec12


class UnhappyException extends LoggedException {
  override def getMessage() = "arrgh!"
}