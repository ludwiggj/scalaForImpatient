//8. Write a Scala program that prints the src attributes of all img tags of a web
//   page. Use regular expressions and groups.

//  <img alt="BBC News" src="http://news.bbcimg.co.uk/img/1_0_3/cream/hi/news/news-blocks.gif" />

import scala.io.Source
import misc.Constants.FILE_ROOT

val source = Source.fromFile(s"$FILE_ROOT/src/main/scala/ch09/questions/08_news.txt", "UTF-8")

val text = source.mkString

val imgPattern = """<img[^>]+src=\"([^\"]+)\"""".r

for (imgPattern(src) <- imgPattern.findAllIn(text))
  println("src: " + src)