import scala.math._
import java.net._
import javax.imageio._
import javax.swing._
import java.io.IOException
var url = "";
def process(u: URL) {
  println(u)
  val img = ImageIO.read(u)
  JOptionPane.showMessageDialog(null, null, null, 0, new ImageIcon(img))
}



try {
  url = "http://horstmann.com/cay-tiny.gif"
  process(new URL(url))
  url = "http://horstmann.com/fred.gif"
  process(new URL(url))
} catch {
  case _: MalformedURLException => println("Bad URL: " + url)
  case ex: IOException => println(ex.toString())
//  case ex: IOException => ex.printStackTrace()
}













try {
  url = "fred://horstmann.com/cay-tiny.gif"
  process(new URL(url))
} catch {
  case _: MalformedURLException => println("Bad URL: " + url)
  case ex: IOException => ex.printStackTrace()
}





