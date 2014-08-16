//Q1 Write a Scala code snippet that reverses the lines in a file (making the last
//   line the first one, and so on).

import java.io.PrintWriter
import scala.io.{BufferedSource, Source}
val homeDir = "./src/main/scala/ch09/questions/"
val sourceFile = homeDir + "01_1to10.txt"
val file: BufferedSource = Source.fromFile(sourceFile, "UTF-8")
val lines = file.getLines.toArray.reverse

file.close()

val out = new PrintWriter(sourceFile)
for (line <- lines) out.println(line)
out.close()