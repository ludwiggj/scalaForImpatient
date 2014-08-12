package ch10.sec12

import ch10.sec04.Logged

trait LoggedException extends Exception with Logged {
  def log() { log(getMessage()) }
}
