package ch10.lectures.sec05

import ch10.lectures.sec04.Logged

trait ShortLogger extends Logged {
  val maxLength = 15

  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
    )
  }
}
