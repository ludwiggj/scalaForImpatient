import scala.io.Source

val source1 = Source.fromURL("http://horstmann.com", "UTF-8")
println(source1.mkString.length + " bytes")

// Reads from the given string—useful for debugging
val source2 = Source.fromString("Hello, World!")
println(source2.mkString.length + " bytes")