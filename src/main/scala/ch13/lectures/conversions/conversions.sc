import scala.collection.JavaConversions._

val props = System.getProperties
val props2: scala.collection.mutable.Map[String, String] = System.getProperties

props2("java.runtime.name")
props2("misterG") = "coolBeans"
props2("misterG")