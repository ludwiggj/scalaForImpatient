package ch12.questions

package object q6 {
  // Yield input value at which output value of a function is largest, given a sequence of inputs
  // Don't use a loop or recursion
  def largestInput1(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    val candidates = for (x <- inputs) yield (x, fun(x))

    def largest(seq: Seq[(Int, Int)]) =
      (seq.reduceLeft _) {
        case ((x, fx), (y, fy)) => if (fx > fy) (x, fx) else (y, fy)
      }

    largest(candidates)._1
  }

  def largestInput2(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    val candidates = for (x <- inputs) yield (x, fun(x))

    def larger(t1: (Int, Int), t2: (Int, Int)): (Int, Int) = {
      t1 match {
        case (_, fx) =>
          t2 match {
            case (_, fy) => if (fx > fy) t1 else t2
          }
      }
    }

    (candidates reduceLeft larger)._1
  }

  def largestInput3(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    val candidates = for (x <- inputs) yield (x, fun(x))

    def larger(t1: (Int, Int), t2: (Int, Int)): (Int, Int) = {
      val (_, fx) = t1
      val (_, fy) = t2
      if (fx > fy) t1 else t2
    }

    (candidates reduceLeft larger)._1
  }
}