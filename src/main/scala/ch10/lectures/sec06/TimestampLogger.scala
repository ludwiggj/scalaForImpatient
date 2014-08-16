package ch10.lectures.sec06

import java.util.Date
import ch10.lectures.sec02.Logger

trait TimestampLogger extends Logger {
  abstract override def log(msg: String) { // Also an abstract method...
    super.log(new Date() + " " + msg)
  }
}
