package ch10.lectures.sec07

trait Logger {
  def log(msg: String)  // Abstract method
  def info(msg: String) { log("INFO: " + msg) }
  def warn(msg: String) { log("WARN: " + msg) }
  def severe(msg: String) { log("SEVERE: " + msg) }
}