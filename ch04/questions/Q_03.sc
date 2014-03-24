//Q2 Write a program that reads words from a file. Use a mutable map to count
//how often each word appears. To read the words, simply use a java.util.Scanner:
//val in = new java.util.Scanner(java.io.File("myfile.txt"))
//while (in.hasNext()) process in.next()
//Or look at Chapter 9 for a Scalaesque way.
//At the end, print out all words and their counts.

val f = new java.io.File("./ch04/questions/myFile.txt")
val in = new java.util.Scanner(f)




// Use an immutable map
var counts = Map[String, Int]()
while (in.hasNext()) {
  val word = in.next()
  print(">" + word + "<")
  counts = counts + (word -> (counts.getOrElse(word, 0) + 1))

}
















for ((k, v) <- counts) println(k, v)





























































































