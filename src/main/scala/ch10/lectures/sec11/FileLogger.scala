package ch10.lectures.sec11

import ch10.lectures.sec07.Logger
import java.io.PrintWriter
import java.util.Date

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintWriter(filename)
  out.println("# " + new Date().toString)

  def log(msg: String) { out.println(msg); out.flush() }
}
