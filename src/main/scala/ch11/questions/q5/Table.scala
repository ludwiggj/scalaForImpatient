package ch11.questions.q5

object Table {
  def apply() = new Table()
}

class Table {
  var tableStart = "<table><tr>"
  var tableEnd = "</tr></table>"
  var currentRow = ""
  override def toString() = tableStart + currentRow + tableEnd

  def |(contents: String) = {
    currentRow += s"<td>$contents</td>"
    this
  }

  def ||(firstColContents: String) = {
    tableStart = tableStart + currentRow + "</tr><tr>"
    currentRow = ""
    |(firstColContents)
  }
}