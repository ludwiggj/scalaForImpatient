package ch10.lectures.sec12

import ch10.lectures.sec04.Logged

trait LoggedException extends Exception with Logged {
  def log() { log(getMessage()) }
}
