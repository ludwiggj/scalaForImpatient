package ch10.sec10

import ch10.sec07.Logger
import java.io.PrintWriter
import java.util.Date

trait FileLogger extends Logger {
  val out = new PrintWriter("app.log")
  out.println("# " + new Date().toString)

  def log(msg: String) { out.println(msg); out.flush() }
}
