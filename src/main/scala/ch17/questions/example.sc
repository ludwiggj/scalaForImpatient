import scala.runtime.RichInt

new RichInt(1).compareTo(2)
new RichInt(1).compareTo(new RichInt(3))