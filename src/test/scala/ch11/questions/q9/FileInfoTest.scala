package ch11.questions.q9

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps
import sbt.RichFile
import java.io.File

class FileInfoTest extends FlatSpec with Matchers {

  "FileInfo" should "work for file with full path name" in {
    val FileInfo(path, fileStem, fileExt) = new RichFile(new File("/a/test/file.txt"))
    path should equal("/a/test")
    fileStem should equal("file")
    fileExt should equal("txt")
  }

  "FileInfo" should "work for file without path name" in {
      val FileInfo(path, fileStem, fileExt) = new RichFile(new File("bob.zip"))
      path should equal("/Users/ludwiggj/code/scalaForImpatient")
      fileStem should equal("bob")
      fileExt should equal("zip")
    }

  "FileInfo" should "work for file in root directory" in {
      val FileInfo(path, fileStem, fileExt) = new RichFile(new File("/bob.zip"))
      path should equal("/")
      fileStem should equal("bob")
      fileExt should equal("zip")
    }

  "FileInfo" should "work for file without an extension" in {
      val FileInfo(path, fileStem, fileExt) = new RichFile(new File("/home/burt"))
      path should equal("/home")
      fileStem should equal("burt")
      fileExt should equal("")
    }
}