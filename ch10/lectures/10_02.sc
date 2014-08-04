import ch10.sec02.Logger

class ConsoleLogger extends Logger with Cloneable with Serializable {
  def log(msg: String) {
    println(msg)
  }
}

new ConsoleLogger().log("This is another test")