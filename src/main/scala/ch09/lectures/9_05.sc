import java.io._
import misc.Constants.FILE_ROOT

val file = new File(s"$FILE_ROOT/src/main/scala/ch09/lectures/repl-session.zip")
val in = new FileInputStream(file)
val bytes = new Array[Byte](file.length.toInt)

in.read(bytes)
in.close()

printf("Zip files starts with %c%c, the initials of their inventor.\n",
        bytes(0), bytes(1))

bytes.mkString(" ")