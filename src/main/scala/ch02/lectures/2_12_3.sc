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

var in = new URL("http://horstmann.com/cay-tiny.gif").openStream()

try {
  process(in)
} finally {
  in.close()
}