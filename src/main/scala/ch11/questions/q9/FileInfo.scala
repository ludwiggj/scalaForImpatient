package ch11.questions.q9

import sbt.RichFile

// define unapply to extract file path, name and extension
object FileInfo {
  def unapply(input: RichFile) = {
    val inputLength = input.name.length
    val absolutePath = input.absolutePath
    val relativePath = if (absolutePath.length == inputLength + 1) {
      absolutePath dropRight inputLength }
    else {
      absolutePath dropRight inputLength + 1
    }
    val (baseFileName, extension) = input.baseAndExt
    Some((relativePath, baseFileName, extension))
  }
}