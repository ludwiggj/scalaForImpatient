package ch12.questions

package object q5 {

  // Yield largest value of a function given a sequence of inputs
  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    val candidates = for (x <- inputs) yield fun(x)

    def largest(seq: Seq[Int]) = seq reduceLeft( (x, y) => if (x > y) x else y )

    largest(candidates)
  }
}