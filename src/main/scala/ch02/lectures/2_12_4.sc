import java.net._
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
var in1 = new URL("http://horstmann.com/fred1.gif").openStream()

try {
  process(in1)
} catch {
  case ex: IOException => println(ex)
} finally {
  in1.close()
}

var in2: InputStream = null
// This is what you want
try {
  in2 = new URL("http://horstmann.com/fred2.gif").openStream()
  try {
    process(in2)
  } finally {
    in2.close()
  }
} catch {
  case ex: IOException => println("Oh dear!:" + ex)
}