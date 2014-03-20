//Q8. Write a function product(s : String) that computes the product, as described
//in the preceding exercises.

def product(x:String) =  x.foldLeft(1L)(_ * _.toInt)

product("Hello")