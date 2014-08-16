package ch10.lectures.sec11

import ch10.lectures.sec07.Logger
import java.io.PrintWriter

trait LazyFileLogger extends Logger {
  val filename: String
  lazy val out = new PrintWriter(filename)

  def log(msg: String) { out.println(msg); out.flush() }
}
