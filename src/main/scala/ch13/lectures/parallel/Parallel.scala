package ch13.lectures.parallel

import scala.collection.mutable

class Parallel {


  def doIt = {

    def reduceInParallel(f: (Int, Int) => Int) = {
      (1 to 15).par.reduce(f)
    }

    def foldInParallel(init: Int, f: (Int, Int) => Int) = {
      (1 to 15).par.fold(init)(f)
    }

    def isEven: (Int) => Boolean = {
      _ % 2 == 0
    }

    def countEvens: Int = {
      var count = 0
      for (c <- (0 to 1000000).par) {
        if (c % 2 == 0) count += 1
      }
      count
    }

    val res = mutable.StringBuilder.newBuilder

    res ++= s"(0 to 1000000).par.sum ${(0 to 1000000).par.sum}\n"
    res ++= s"Number of evens in (0 to 1000000) ${(0 to 1000000).par.count(isEven)}\n"
    res ++= s"(0 to 100) "
    for (i <- (0 until 100)) res ++= (i + " ")
    res ++= "\n(0 to 100).par "
    for (i <- (0 until 100).par) res ++= (i + " ")
    res ++= s"\n(0 to 100).par yield ${for (i <- (0 until 100).par) yield (i + " ")}\n"
    res ++= s"Number of evens in (0 to 1000000).par $countEvens\n"
    res ++= s"(1 to 15).par.sum ${(1 to 15).par.sum}\n"
    res ++= s"reduceInParallel (1 to 15).add ${reduceInParallel(_ + _)}\n"
    res ++= s"reduceInParallel (1 to 15).minus ${reduceInParallel(_ - _)}\n"
    res ++= s"reduceInParallel (1 to 15).multiply ${reduceInParallel(_ * _)}\n"
    res ++= s"foldInParallel (1 to 15).add ${foldInParallel(0, (_ + _))}\n"
    res ++= s"foldInParallel (1 to 15).minus ${foldInParallel(0, (_ - _))}\n"
    res ++= s"foldInParallel (1 to 15).multiply ${foldInParallel(1, (_ * _))}\n"

    val uniqueChars = "hello".par.aggregate(Set[Char]())((x, y) => {
      res ++= s"x $x, y $y, x + y ${x + y}\n"
      x + y
    }, _ ++ _)

    res ++= s"hello.aggregate uniqueChars $uniqueChars"

    res
  }
}

object Main extends App {
  println(new Parallel().doIt)
}