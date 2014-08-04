package ch10.sec05

import scala.util.logging.Logged
import java.util.Date

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new Date() + " " + msg)
  }
}
