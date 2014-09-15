package ch11.questions.q10

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps
import sbt.RichFile
import java.io.File

class FileInfoTest extends FlatSpec with Matchers {

  "FileInfo" should "work for file with full path name" in {
    new RichFile(new File("/home/cay/bay/readme.txt")) match {
      case FileInfo(a, b, _, c) =>
        a should equal("home")
        b should equal("cay")
        c should equal("readme.txt")
      case _ => fail("No match")
    }
  }

  // NOTE: Path expanded into Users/ludwiggj/code/scalaForImpatient/bay/readme.txt
  "FileInfo" should "work for file without leading slash" in {
    new RichFile(new File("bay/readme.txt")) match {
      case FileInfo(_, _, _, _, a, b) =>
        a should equal("bay")
        b should equal("readme.txt")
      case _ => fail("No match")
    }
  }

  "FileInfo" should "work for top level file" in {
    new RichFile(new File("/readme.txt")) match {
      case FileInfo(a) =>
        a should equal("readme.txt")
      case _ => fail("No match")
    }
  }
}