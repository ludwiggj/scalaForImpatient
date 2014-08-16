import java.io.File

def subdirs(dir: File): Iterator[File] = {
  println(s"subdirs for $dir")
  val children = dir.listFiles.filter(_.isDirectory)
  children.toIterator ++ children.toIterator.flatMap(subdirs _)
}
val home = new File(System.getProperty("user.home"))
val dirs = subdirs(home)

for (d <- dirs take 50)
  println(d)