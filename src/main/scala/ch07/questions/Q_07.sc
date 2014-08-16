//6. Write a program that copies all elements from a Java hash map into a Scala
//   hash map. Use imports to rename both classes.
//7. In the preceding exercise, move all imports into the innermost scope possible.

import java.util.{HashMap => JavaHashMap}

val j = new JavaHashMap[String, Int]{{
  put("One", 1)
  put("Two", 2)
  put("Three", 3)
}}

import scala.collection.mutable.{HashMap => ScalaHashMap}
val s = new ScalaHashMap[String, Int]

import scala.collection.JavaConversions._
s.putAll(j)
s