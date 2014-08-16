package ch10.lectures.sec09

import ch10.lectures.sec04.Logged

trait ShortLogger extends Logged {
  val maxLength: Int

  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
    )
  }
}