import java.nio.file._
import java.io.File

implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
  override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
    f(p)
    FileVisitResult.CONTINUE
  }
}

Files.walkFileTree(new File(".").toPath, (f: Path) => println(f))