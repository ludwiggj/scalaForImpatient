package ch11.questions.q6

class ASCIIArt(val pic: String) {
  def +(other: ASCIIArt) = {
    val lined = pic.split("\n")
    val otherLined = other.pic.split("\n")
    val merged = lined zipAll (otherLined, "", "") map (line => line._1 + line._2)
    ASCIIArt(merged.mkString("\n"))
  }

  def *(other: ASCIIArt) = {
    ASCIIArt(pic + other.pic)
  }

  override def toString = pic
}

object ASCIIArt {
  def apply(pic: String) = new ASCIIArt(pic)
}

object Main extends App {
  val catPic =
    """
 /\_/\.
( ' ' )
(  -  )
 | | |.
(--|--)
    """

  val speechPic =
    """
     -----..
   / Hello \
  <  Scala |
   \ Coder /
     -----..
    """

  val cat = ASCIIArt(catPic)
  val speech = ASCIIArt(speechPic)

  println(cat)
  println(speech)
  println(speech + cat)
  println(cat + speech)
  println(cat * cat + speech * speech)
  println(cat + speech * cat + cat)
  println((cat + speech) * (cat + cat))
}