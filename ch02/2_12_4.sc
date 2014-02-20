//import scala.math._
import java.net._
//import javax.imageio._
//import javax.swing._

// -- Change to input stream

import java.io._

def process(in: InputStream) {
  var bytes = -1
  var next = 0
  while (next != -1) {
    next = in.read()
    bytes += 1
  }
  println(bytes + " bytes")
}

// try/catch/finally is no good--what if close throws an exception?

var in = new URL("http://horstmann.com/fred1.gif").openStream()









































try {
  process(in)
} catch {
  case ex: IOException => println(ex)
} finally {
  in.close()
}






// This is what you want

try {
  in = new URL("http://horstmann.com/fred2.gif").openStream()
  try {
    process(in)
  } finally {
    in.close()
  }
} catch {
  case ex: IOException => println(ex)
}