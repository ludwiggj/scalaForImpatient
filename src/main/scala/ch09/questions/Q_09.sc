//9. Write a Scala program that counts how many files with .class extension are
//   in a given directory and its subdirectories.

import java.io.File
import misc.Constants.FILE_ROOT

def subdirs(dir: File): Iterator[File] = {
  val children = dir.listFiles.filter(_.isDirectory)
  children.toIterator ++ children.toIterator.flatMap(subdirs _)
}

def currentDirAndSubdirs(dir: File): Iterator[File] = {
  Array(dir).toIterator ++ subdirs(dir)
}

def isAClassFile(f: File) = f.isFile && f.getName.contains(".class")

def displayFileCount(root: File) = {
  val dirs = currentDirAndSubdirs(root)
  println (s"Number of class files in [${root.getName}] is ${(dirs flatMap(_.listFiles.filter(isAClassFile(_)))).size}")
}

displayFileCount(new File(s"$FILE_ROOT/out"))
displayFileCount(new File(s"$FILE_ROOT/out/production/scalaForImpatient/ch08"))

/*
for (d <- dirs take 5)
  for (f <- d.listFiles.filter(isAClassFile(_)))
    println (f.getName)
*/