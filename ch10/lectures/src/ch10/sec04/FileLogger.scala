package ch10.sec04

import java.io.PrintWriter

trait FileLogger extends Logged {
  val homeDir = "./ch10/lectures/"
  val sourceFile = homeDir + "ch10.sec04.txt"

  override def log(msg: String) {
    val out = new PrintWriter(sourceFile)
    out.println(msg)
    out.close()
  }
}