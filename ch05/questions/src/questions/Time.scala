package questions

// Note: javap reveals that h and m parameters do not become fields in class file!
class Time(h: Int, m: Int) {
  private val hours = {
    if (inRange(h, 0, 23)) h else 0
  }

  private val minutes = {
    if (inRange(m, 0, 59)) m else 0
  }

  override def toString = s"h $hours m $minutes"

  private def inRange(value: Int, lowerInc: Int, upperInc: Int) = {
    (value >= lowerInc) && (value <= upperInc)
  }

  def before(other: Time) = {
    (hours < other.hours) || ((hours == other.hours) && (minutes < other.minutes))
  }
}