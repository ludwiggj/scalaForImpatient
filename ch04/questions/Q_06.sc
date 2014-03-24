//Q6 Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
//similarly for the other weekdays. Demonstrate that the elements are visited
//in insertion order.

import java.util.Calendar._

val months = scala.collection.mutable.LinkedHashMap(
  "Monday" -> MONDAY,
  "Tuesday" -> TUESDAY,
  "Wednesday" -> WEDNESDAY,
  "Thursday" -> THURSDAY,
  "Friday" -> FRIDAY,
  "Saturday" -> SATURDAY,
  "Sunday" -> SUNDAY)



for ((k, v) <- months) println(k, v)





