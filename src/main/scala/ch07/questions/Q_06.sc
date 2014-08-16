//6. Write a program that copies all elements from a Java hash map into a Scala
//   hash map. Use imports to rename both classes.

import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}

val j = new JavaHashMap[String, Int]{{
  put("One", 1)
  put("Two", 2)
  put("Three", 3)
}}
val s = new ScalaHashMap[String, Int]

// Following doesn't work...

//for (e <- j.entrySet()) {
//  s += (e.getKey -> e.getValue)
//}
//error: value foreach is not a member of java.util.Set[java.util.Map.Entry[String,Int]]

import scala.collection.JavaConversions._

j.foreach(kv => println(kv._1 + " -> " + kv._2))
j.foreach(kv => s += (kv._1 -> kv._2))

s

// An alternative
val t = new ScalaHashMap[String, Int]
t.putAll(j)
t

// Alternative
import scala.collection.JavaConverters._
j.asScala