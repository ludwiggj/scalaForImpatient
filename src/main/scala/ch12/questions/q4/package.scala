package ch12.questions

package object q4 {

  // Implement factorial using to and foldLeft without a loop or recursion
  def factorial(n: Int) = (1 to n).foldLeft(1)(_ * _)
}
