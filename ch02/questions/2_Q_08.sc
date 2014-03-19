def product(x:String) =  x.foldLeft(1L)(_ * _.toInt)

product("Hello")