package questions.q1
package com
package horstmann
package impatient

object Unchained extends App {
  // Widget type is now visible
  println((new Widget).describe)

  // Can also use full path qualifier
  println((new questions.q1.com.horstmann.Widget).describe)
}