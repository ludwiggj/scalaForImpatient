package sec02 {
package com {
  package horstmann {
    object Utils {
      def percentOf(value: Double, rate: Double) = value * rate / 100
    }

    package impatient {
      class Employee(initialSalary: Double) {
        private var salary = initialSalary
        def description = "An employee with salary " + salary
        def giveRaise(rate: scala.Double) {
          salary += Utils.percentOf(salary, rate)
          // Ok to access Utils from parent package
        }
      }

    object AnotherMain extends App {
      // Due to scope of this object, can use class names without leading package names
      val fred = new Employee(50000)
      fred.giveRaise(20)
      println(fred + ": " + fred.description)

      val wilma = new Manager
      wilma.subordinates += fred
      wilma.subordinates += new Employee(50000)
      println(wilma + ": " + wilma.description)
    }

    }
  }
}

object Main extends App {
  // Employee not in scope here
  // val freda = new Employee(50000)
  val fred = new sec02.com.horstmann.impatient.Employee(50000)
  fred.giveRaise(10)
  println(fred + ": " + fred.description)

  val wilma = new sec02.com.horstmann.impatient.Manager
  wilma.subordinates += fred
  wilma.subordinates += new sec02.com.horstmann.impatient.Employee(50000)
  println(wilma + ": " + wilma.description)
}
}