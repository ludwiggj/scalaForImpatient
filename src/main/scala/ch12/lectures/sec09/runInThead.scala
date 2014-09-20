package ch12.lectures.sec09

// Control abstractions

object Main extends App {
  def runInThread(block: () => Unit) {
    new Thread {
      override def run() {
        block()
      }
    }.start()
  }

  // Following argument is of wrong type
  // Expected () => Unit, actual is Unit
  // runInThread { println("Hi"); Thread.sleep(10000); println("Bye") }
  runInThread {
    () =>
      println("Hi1")
      Thread.sleep(3000)
      println("Bye1")
  }

  // Now use call by name notation

  def runInAnotherThread(block: => Unit) {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  runInAnotherThread {
    println("Hi2")
    Thread.sleep(2000)
    println("Bye2")
  }
}