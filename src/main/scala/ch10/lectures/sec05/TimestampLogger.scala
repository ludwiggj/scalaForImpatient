package ch10.lectures.sec05

import java.util.Date
import ch10.lectures.sec04.Logged

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new Date() + " " + msg)
  }
}
