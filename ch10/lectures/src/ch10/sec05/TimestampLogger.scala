package ch10.sec05

import java.util.Date
import ch10.sec04.Logged

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new Date() + " " + msg)
  }
}
