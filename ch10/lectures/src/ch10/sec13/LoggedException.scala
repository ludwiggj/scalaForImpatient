package ch10.sec13

import ch10.sec04.Logged

trait LoggedException extends Logged {
  this: Exception =>
  def log() {
    log(getMessage())
  }
}
