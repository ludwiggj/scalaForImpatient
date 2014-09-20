package ch12.questions

// Implement factorial using to and reduceLeft without a loop or recursion

package object q3 {
  def factorial(n: Int) = if (n < 1) 1 else 1 to n reduceLeft(_ * _)
}
