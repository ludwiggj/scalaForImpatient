package ch10.lectures.sec13

import ch10.lectures.sec04.Logged

trait LoggedException2 extends Logged {
  this: { def getMessage(): String } =>
  def log() {
    log(getMessage())
  }
}

class Gin {}

class And {
  def getMessage(): String = { "blah" }
}

class Tonic extends { def getMessage(): String = { "blah" } }

object Main extends App {

  // Following example fails with:

  // illegal inheritance;
  // self-type ch10.sec13.Gin with ch10.sec13.LoggedException2 does not conform to
  // ch10.sec13.LoggedException2's selftype
  // ch10.sec13.LoggedException2 with AnyRef{def getMessage(): String}

  //  val anotherException = new Gin with LoggedException2 {
  //    def getMessage(): String = {
  //      "blah"
  //    }
  //  }

  // Can't use early definition either (doesn't compile) ...
  // val anotherException = new {
  //      def getMessage(): String = { "blah" }
  // } with Gin with LoggedException2

  val exception1 = new And with LoggedException2
  val exception2 = new Tonic with LoggedException2
}