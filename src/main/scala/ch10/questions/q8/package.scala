package ch10.questions

import java.io.InputStream

package object q8 {
  // Printing as we go
  def printMaxBytes(inputStream: InputStream, maxBytes: Int) {
    println(getMaxBytes(inputStream, maxBytes))
  }

  // Get a max number of bytes from an input stream
  // Get all of them if maxBytes is < 0
  def getMaxBytes(inputStream: InputStream, maxBytes: Int) = {
    val bytes = new StringBuilder
    var byteCount = 0
    var byte: Int = 0
    while ((byte != -1) && ((byteCount < maxBytes) || (maxBytes < 0))) {
      byte = inputStream.read()
      bytes.append(byte + " ")
      byteCount += 1
    }
    bytes.toString()
  }
}