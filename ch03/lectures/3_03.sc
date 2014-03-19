val a = Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)

for (i <- 0 until a.length)
  print("(" + i + ": " + a(i) + ") ")

for (i <- 0 until (a.length, 2))
  print("(" + i + ": " + a(i) + ") ")

for (i <- (0 until a.length).reverse)
  print("(" + i + ": " + a(i) + ") ")

for (elem <- a)
  println(elem)










