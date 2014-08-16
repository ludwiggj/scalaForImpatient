package ch05.questions.misc

// Note: javap reveals that h and m parameters do not become fields in class file!
class Time2(h: Int, m: Int) {

  private val totalMinutes = {
    var hoursAsMins = if (inRange(h, 0, 23)) h*60 else 0
    if (inRange(m, 0, 59)) (hoursAsMins + m) else hoursAsMins
  }

  override def toString = s"h ${totalMinutes / 60} m ${totalMinutes % 60} totalMins $totalMinutes"

  private def inRange(value: Int, lowerInc: Int, upperInc: Int) = {
    (value >= lowerInc) && (value <= upperInc)
  }

  def before(other: Time2) = {
    totalMinutes < other.totalMinutes
  }
}