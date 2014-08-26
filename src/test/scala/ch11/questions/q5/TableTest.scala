package ch11.questions.q5

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

trait Amounts {
  val table = """Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET""""
  val output = "<table>" +
    "<tr><td>Java</td><td>Scala</td></tr>" +
    "<tr><td>Gosling</td><td>Odersky</td></tr>" +
    "<tr><td>JVM</td><td>JVM, .NET</td></tr>" +
    "</table>"
}

class TableTest extends FlatSpec with Matchers {

  "Table()" should "return return html table with single row" in {
    Table().toString() should equal("<table><tr></tr></table>")
  }

  "| text" should "return html table cell with text as contents" in {
    (Table() | "Java").toString() should equal("<table><tr><td>Java</td></tr></table>")
  }

  "| text twice in same row" should "return html row with 2 table cells" in {
    (Table() | "Java" | "Scala").toString() should equal("<table><tr><td>Java</td><td>Scala</td></tr></table>")
  }

  "||" should "should start a new row" in {
    (Table() | "Java" | "Scala" || "Gosling").toString() should equal ("<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling</td></tr></table>")
  }

  "Textbook example" should "work" in {
    (Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET").toString() should equal (
        "<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling</td><td>Odersky</td></tr><tr><td>JVM</td><td>JVM, .NET</td></tr></table>")
  }
}