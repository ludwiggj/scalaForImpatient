//Q5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.

def countdown(n: Int) {
  for (i <- (0 to n).reverse) println(i)
}

countdown(5)





countdown(0)
countdown(-5)