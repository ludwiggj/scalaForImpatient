import scala.sys.process._

"ls -al .." !  // returns 0, which indicates successful completion

val result = "ls -al .." !! // result returned as a string and assigned to val

val outcome1 = "ls -al .." #| "grep sec" ! // fails - sec not in file

val outcome2 = "ls -al .." #| "grep scala" !

import java.io.File

val attempt1 = "ls -al .." #> new File("./src/main/scala/ch09/lectures/output.txt") !  // output to file

val attempt2 = "ls -al .." #>> new File("./src/main/scala/ch09/lectures/output.txt") ! // append to file

val read = "grep scala" #< new File("./src/main/scala/ch09/lectures/output.txt") !

import java.net.URL

val urlScrape = "grep Scala" #< new URL("http://horstmann.com/index.html") !

val cmd = "ls"
val dirName = "./src/main/scala/ch09/lectures/"
val p = Process(cmd, new File(dirName), ("LANG", "en_US"))
"echo 42" #| p !