package ch11.questions.q10

import sbt.RichFile

object FileInfo {

  def unapplySeq(input: RichFile): Option[Seq[String]] = {
    val name = if (input.absolutePath(0) == '/') (input.absolutePath drop 1) else input.absolutePath
    println(s"Name $name")
    val x: Option[Seq[String]] = if (name == "") None else Some(name.split("/"))
    println(s"$x")
    x
  }
}