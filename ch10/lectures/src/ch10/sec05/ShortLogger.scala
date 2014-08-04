package ch10.sec05

import scala.util.logging.Logged

trait ShortLogger extends Logged {
  val maxLength = 15

  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
    )
  }
}
