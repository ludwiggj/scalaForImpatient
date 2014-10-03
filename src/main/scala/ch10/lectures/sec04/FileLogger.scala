package ch10.lectures.sec04

import java.io.PrintWriter
import misc.Constants.FILE_ROOT

trait FileLogger extends Logged {
  val homeDir = s"$FILE_ROOT/src/main/scala/ch10/lectures/"
  val sourceFile = homeDir + "ch10.sec04.txt"

  override def log(msg: String) {
    val out = new PrintWriter(sourceFile)
    out.println(msg)
    out.close()
  }
}