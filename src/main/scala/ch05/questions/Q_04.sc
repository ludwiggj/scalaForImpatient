//4. Reimplement the Time class from the preceding exercise so that the internal
//   representation is the number of minutes since midnight (between 0 and
//   24 × 60 – 1). Do not change the public interface. That is, client code should be
//   unaffected by your change.

class Time(h: Int, m: Int) {

  private val totalMinutes = {
    var hoursAsMins = if (inRange(h, 0, 23)) h*60 else 0
    if (inRange(m, 0, 59)) (hoursAsMins + m) else hoursAsMins
  }

  override def toString = s"h ${totalMinutes / 60} m ${totalMinutes % 60} totalMins $totalMinutes"

  private def inRange(value: Int, lowerInc: Int, upperInc: Int) = {
    (value >= lowerInc) && (value <= upperInc)
  }

  def before(other: Time) = {
    totalMinutes < other.totalMinutes
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