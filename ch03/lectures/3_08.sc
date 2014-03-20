import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable.ArrayBuffer

val command = ArrayBuffer("ls", "-al", "/home/cay")

val pb = new ProcessBuilder(command) // Scala to Java

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

val cmd : Buffer[String] = pb.command() // Java to Scala, can't use ArrayBuffer, must use Buffer

cmd == command

