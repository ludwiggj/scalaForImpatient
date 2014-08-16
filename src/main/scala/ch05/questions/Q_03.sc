//3. Write a class Time with read-only properties hours and minutes and a method
//   before(other: Time): Boolean that checks whether this time comes before the
//   other. A Time object should be constructed as new Time(hrs, min), where hrs
//   is in military time format (between 0 and 23).

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
new Time(23, 59)
new Time(24, 59)
new Time(12, -6)

(new Time(12, 0)) before (new Time(12, 12))
(new Time(12, 0)) before (new Time(11, 59))
(new Time(12, 0)) before (new Time(12, 0))
(new Time(12, 0)) before (new Time(15, 31))
(new Time(12, 39)) before (new Time(12, 31))