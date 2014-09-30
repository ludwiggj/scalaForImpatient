package ch11.questions.q10

import sbt.RichFile
import java.io.File
import org.junit.Test
import org.expecty.Expecty
import org.scalatest.Assertions.fail

class FileInfoExpectyTest {

  val expect = new Expecty(failEarly = false)

  @Test
  def fileInfoShouldWorkForFileWithoutLeadingSlash() {
    new RichFile(new File("bay/readme.txt")) match {
      case FileInfo(_, _, _, _, a, b) =>
        expect {
          a == "bay"
          b == "readme.txt"
        }
      case _ => fail("No match")
    }
  }
}