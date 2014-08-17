package ch10.questions

import java.io.InputStream

package object q8 {
  // Get a max number of bytes from an input stream
  // Printing as we go
  // Get all of them if maxBytes is < 0
  def printMaxBytes(inputStream: InputStream, maxBytes: Int) {
    var byteCount = 0
    var byte: Int = 0
    while ((byte != -1) && ((byteCount < maxBytes) || (maxBytes < 0))) {
      byte = inputStream.read()
      byteCount += 1
      print(byte + " ")
    }
    println
  }
}