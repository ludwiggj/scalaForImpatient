// Q9 Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
//   that are in America. Strip off the "America/" prefix and sort the result.
import scala.language.postfixOps
import java.util.TimeZone
val zones = TimeZone.getAvailableIDs filter (_ startsWith "America") map (_ drop 8) sorted