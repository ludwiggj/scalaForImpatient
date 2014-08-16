package ch10.lectures.sec13

import ch10.lectures.sec04.Logged


trait LoggedException extends Logged {
  this: Exception =>
  def log() {
    log(getMessage())
  }
}
