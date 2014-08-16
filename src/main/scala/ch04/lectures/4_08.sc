val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

for ((s, n) <- pairs) Console.print(s * n)

symbols.zip(counts).toMap