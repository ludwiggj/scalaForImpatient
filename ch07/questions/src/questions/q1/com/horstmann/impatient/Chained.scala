package questions.q1.com.horstmann.impatient

object Chained extends App {
   // Widget type is not visible without full path import
//   (new Widget).describe

   // Have to use full path qualifier
   println((new questions.q1.com.horstmann.Widget).describe)
 }